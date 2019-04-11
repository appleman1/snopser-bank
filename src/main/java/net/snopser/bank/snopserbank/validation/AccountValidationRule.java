package net.snopser.bank.snopserbank.validation;

import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.model.Result;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
public class AccountValidationRule implements ValidationRule {
    @Override
    public Result check(Operation operation) {
        return null;
    }
}
