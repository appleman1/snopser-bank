package net.snopser.bank.snopserbank.validation.rule;

import net.snopser.bank.snopserbank.entity.Account;
import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.repository.AccountRepository;
import net.snopser.bank.snopserbank.validation.ValidationRule;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

/**
 * @author Виктор Фалькенберг
 */
@Component
public class ClientAccountSenderValidationRule implements ValidationRule {

    private final AccountRepository accountRepository;
    private final MessageSource messageSource;

    public ClientAccountSenderValidationRule(AccountRepository accountRepository, MessageSource messageSource) {
        this.accountRepository = accountRepository;
        this.messageSource = messageSource;
    }

    @Override
    public List<String> check(Operation operation) {
        Optional<BigInteger> isPresentClientSenderAccount = accountRepository.findByClientId(operation.getClient().getClientId())
                .stream()
                .map(Account::getAccountId)
                .filter(account -> account.equals(operation.getSenderAccount())).findAny();
        if (!isPresentClientSenderAccount.isPresent()) {
            return asList(messageSource.getMessage("snopser-bank.validation.client-account-sender.not-found", new String[]{operation.getSenderAccount().toString()}, null));
        }
        return Collections.emptyList();
    }
}
