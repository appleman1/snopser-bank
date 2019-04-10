package net.snopser.bank.snopserbank.service.implementation;

import net.snopser.bank.snopserbank.entity.Account;
import net.snopser.bank.snopserbank.entity.OperationLog;
import net.snopser.bank.snopserbank.model.Result;
import net.snopser.bank.snopserbank.model.Status;
import net.snopser.bank.snopserbank.repository.AccountRepository;
import net.snopser.bank.snopserbank.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private final DefaultOperationLogService operationLogService;

    public DefaultAccountService(AccountRepository accountRepository, DefaultOperationLogService operationLogService) {
        this.accountRepository = accountRepository;
        this.operationLogService = operationLogService;
    }


    @Override
    @Transactional
    public Result innerTransfer(BigInteger from, BigInteger to, BigDecimal count) {
        OperationLog operationLogFrom = new OperationLog(from, WITHDRAWAL);
        OperationLog operationLogTo = new OperationLog(to, REPLENISHMENT);
        List<OperationLog> logList = asList(operationLogFrom, operationLogTo);
        try {
            operationLogService.saveTransfer(logList);
            List<BigInteger> listAccountId = new ArrayList<>();
            listAccountId.add(from);
            listAccountId.add(to);
            List<Account> findAccounts = accountRepository.findAllById(listAccountId);
            findAccounts.forEach(account -> {
                if (account.getAccountId().equals(from)) {
                    account.setCount(account.getCount().subtract(count));
                }
                if (account.getAccountId().equals(to)) {
                    account.setCount(account.getCount().add(count));
                }
            });
            accountRepository.saveAll(findAccounts);
            setStatusLog(logList, SUCCESS);
            operationLogService.saveTransfer(logList);
        } catch (Exception e) {
            setStatusLog(logList, FAILED);
            operationLogService.saveTransfer(logList);
            throw new RuntimeException();
        }
        return Result.builder().messages(asList("snopser-bank.inner-transfer.ok")).build();
    }

    @Override
    public Result outerTransfer(Integer from, Integer to, BigDecimal count) {
        return null;
    }

    private void setStatusLog(List<OperationLog> logs, Status status) {
        logs.forEach(log -> {
            log.setEndDate(LocalDateTime.now());
            log.setStatusId(status);
        });
    }
}
