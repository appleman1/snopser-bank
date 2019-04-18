package net.snopser.bank.snopserbank.validation.rule;

import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.repository.AccountRepository;
import net.snopser.bank.snopserbank.validation.ValidationRule;
import net.snopser.bank.snopserbank.validation.ValidationRuleDecorator;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@Component
public class CountTransferDecoratorValidationRule extends ValidationRuleDecorator {

    private final AccountRepository accountRepository;
    private final MessageSource messageSource;

    public CountTransferDecoratorValidationRule(List<ValidationRule> validationRule, AccountRepository accountRepository, MessageSource messageSource) {
        super(validationRule);
        this.accountRepository = accountRepository;
        this.messageSource = messageSource;
    }


    @Override
    public List<String> newCheck(Operation operation) {
        BigDecimal countAccountSender = accountRepository.findById(operation.getSenderAccount()).get().getCount();
        if (countAccountSender.compareTo(operation.getCount()) < 0) {
            return asList(messageSource.getMessage("snopser-bank.validation.client-account-sender.count.error", null, null));
        }
        return Collections.emptyList();
    }
}
