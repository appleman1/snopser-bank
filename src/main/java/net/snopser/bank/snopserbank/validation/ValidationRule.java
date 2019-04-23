package net.snopser.bank.snopserbank.validation;

import net.snopser.bank.snopserbank.model.Operation;

import java.util.List;

/**
 * @author Виктор Фалькенберг
 */
public interface ValidationRule {
    List<String> check(Operation operation);
}
