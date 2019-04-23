package net.snopser.bank.snopserbank.validation.rule;

import net.snopser.bank.snopserbank.entity.Bank;
import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.repository.AccountRepository;
import net.snopser.bank.snopserbank.repository.BankRepository;
import net.snopser.bank.snopserbank.validation.ValidationRule;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * @author Виктор Фалькенберг
 */
@Component
public class AccountRecieverValidationRule implements ValidationRule {
    private final BankRepository bankRepository;
    private final MessageSource messageSource;

    public AccountRecieverValidationRule(BankRepository bankRepository, MessageSource messageSource) {
        this.bankRepository = bankRepository;
        this.messageSource = messageSource;
    }

    @Override
    public List<String> check(Operation operation) {
        List<Integer> listBankCode = bankRepository.findAll().stream().map(Bank::getCode).collect(Collectors.toList());
        int bankCode = Integer.parseInt(operation.getRecieverAccount().toString().substring(0, 4));
        if (listBankCode.contains(bankCode) && operation.getRecieverAccount().toString().length() == 10) {
            return Collections.emptyList();
        }
        return asList(messageSource.getMessage(
                "snopser-bank.validation.client-account-reciever.not-correct",
                new String[]{operation.getRecieverAccount().toString()},
                null
        ));
    }
}
