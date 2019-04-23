package net.snopser.bank.snopserbank.validation;

import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.model.Result;

/**
 * @author Виктор Фалькенберг
 */
public interface Validator {
    Result validate(Operation operation);
}
