package net.snopser.bank.snopserbank.validation;

import net.snopser.bank.snopserbank.model.Message;
import net.snopser.bank.snopserbank.model.Operation;

import java.util.List;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
public interface ValidationRule {
    List<String> check(Operation operation);
}
