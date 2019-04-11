package net.snopser.bank.snopserbank.validation;

import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.model.Result;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
public interface ValidationRule {
    Result check(Operation operation);
}
