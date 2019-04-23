package net.snopser.bank.snopserbank.service;

import net.snopser.bank.snopserbank.model.Operation;
import net.snopser.bank.snopserbank.model.Result;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Виктор Фалькенберг
 */
public interface AccountService {

    Result innerTransfer(Operation operation);
}
