package net.snopser.bank.snopserbank.validation;

import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.model.Result;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
abstract public class ValidationRuleDecorator implements ValidationRule {
    protected ValidationRule validationRule;

    public ValidationRuleDecorator(ValidationRule validationRule) {
        this.validationRule = validationRule;
    }

    @Override
    public Result check(Operation operation) {
        return validationRule.check(operation);
    }

    public Result newCheck(Operation operation) {
        return Result.builder().build();
    }
}
