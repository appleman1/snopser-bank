package net.snopser.bank.snopserbank.validation;

import net.snopser.bank.snopserbank.model.Operation;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Виктор Фалькенберг
 */
abstract public class ValidationRuleDecorator implements ValidationRule {
    private List<ValidationRule> validationRule;

    public ValidationRuleDecorator(List<ValidationRule> validationRule) {
        this.validationRule = validationRule;
    }

    @Override
    public List<String> check(Operation operation) {
        return validationRule.stream()
                .map(rule -> rule.check(operation))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public abstract List<String> newCheck(Operation operation);
}
