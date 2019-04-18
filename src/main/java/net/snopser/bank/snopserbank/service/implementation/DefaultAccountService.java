package net.snopser.bank.snopserbank.service.implementation;

import net.snopser.bank.snopserbank.entity.Account;
import net.snopser.bank.snopserbank.entity.OperationLog;
import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.model.Result;
import net.snopser.bank.snopserbank.model.Status;
import net.snopser.bank.snopserbank.repository.AccountRepository;
import net.snopser.bank.snopserbank.repository.OperationLogRepository;
import net.snopser.bank.snopserbank.service.AccountService;
import net.snopser.bank.snopserbank.validation.Validator;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static net.snopser.bank.snopserbank.model.OperationType.REPLENISHMENT;
import static net.snopser.bank.snopserbank.model.OperationType.WITHDRAWAL;
import static net.snopser.bank.snopserbank.model.Status.FAILED;
import static net.snopser.bank.snopserbank.model.Status.SUCCESS;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@Service
public class DefaultAccountService implements AccountService {
    private final AccountRepository accountRepository;
    private final OperationLogRepository operationLogRepository;
    private final Validator validator;
    private final MessageSource messageSource;

    public DefaultAccountService(AccountRepository accountRepository, OperationLogRepository operationLogRepository, Validator validator, MessageSource messageSource) {
        this.accountRepository = accountRepository;

        this.operationLogRepository = operationLogRepository;
        this.validator = validator;
        this.messageSource = messageSource;
    }


    @Override
    @Transactional
    public Result innerTransfer(Operation operation) {
        Result.ResultBuilder resultTransfer = Result.builder().clientLogin(operation.getClient().getLogin());
        OperationLog operationLogFrom = new OperationLog(operation.getSenderAccount(), WITHDRAWAL);
        OperationLog operationLogTo = new OperationLog(operation.getRecieverAccount(), REPLENISHMENT);
        List<OperationLog> logList = asList(operationLogFrom, operationLogTo);
        try {
            //Сохраняем логи в таблицу OperationLogs
            operationLogRepository.saveAll(logList);
            Collection<String> validate = validator.validate(operation).getMessages();
            if (!validate.isEmpty()) {
                setStatusLog(logList, FAILED);
                operationLogRepository.saveAll(logList);
                return resultTransfer.messages(validate).build();
            }
            List<BigInteger> listAccountId = new ArrayList<>();
            listAccountId.add(operation.getSenderAccount());
            listAccountId.add(operation.getRecieverAccount());
            //Находим аккаунты принадлежищие номерам счетов
            List<Account> findAccounts = accountRepository.findAllById(listAccountId);
            //Проходим по аккаунтам, обновляем информцию о счетах
            findAccounts.forEach(account -> {
                if (account.getAccountId().equals(operation.getSenderAccount())) {
                    account.setCount(account.getCount().subtract(operation.getCount()));
                }
                if (account.getAccountId().equals(operation.getRecieverAccount())) {
                    account.setCount(account.getCount().add(operation.getCount()));
                }
            });
            //обновляем сущности аккаунтов
            accountRepository.saveAll(findAccounts);
            setStatusLog(logList, SUCCESS);
            //обновляем логи
            operationLogRepository.saveAll(logList);
        } catch (Exception e) {
            setStatusLog(logList, FAILED);
            operationLogRepository.saveAll(logList);
            throw new RuntimeException();
        }
        return resultTransfer.messages(asList(messageSource.getMessage("snopser-bank.inner-transfer.ok", null, null))).build();
    }

    private void setStatusLog(List<OperationLog> logs, Status status) {
        logs.forEach(log -> {
            log.setEndDate(LocalDateTime.now());
            log.setStatusId(status);
        });
    }
}
