package net.snopser.bank.snopserbank.validation;

import net.snopser.bank.snopserbank.repository.AccountRepository;
import net.snopser.bank.snopserbank.repository.BankRepository;
import net.snopser.bank.snopserbank.validation.rule.AccountRecieverValidationRule;
import net.snopser.bank.snopserbank.validation.rule.ClientAccountSenderValidationRule;
import net.snopser.bank.snopserbank.validation.rule.CountTransferDecoratorValidationRule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {DefaultValidatorTest.TestConfig.class})
class DefaultValidatorTest {
    @Autowired
    private Validator validator;

    @Test
    void test() {
        System.out.println();
    }

    @TestConfiguration
    public static class TestConfig {

        @Bean
        public List<ValidationRule> validationRules(BankRepository bankRepository, AccountRepository accountRepository, MessageSource messageSource) {
            List<ValidationRule> list = new ArrayList<>();
            list.add(new AccountRecieverValidationRule(bankRepository, messageSource));
            list.add(new ClientAccountSenderValidationRule(accountRepository, messageSource));
            list.add(new CountTransferDecoratorValidationRule(list, accountRepository, messageSource));
            return list;
        }

        @Bean
        public Validator validator(List<ValidationRule> listRule) {
            return new DefaultValidator(listRule);
        }
    }

}