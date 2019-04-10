package net.snopser.bank.snopserbank.service;

import net.snopser.bank.snopserbank.model.Result;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
public interface AccountService {

    Result innerTransfer(BigInteger from, BigInteger to, BigDecimal count);

    Result outerTransfer(Integer from, Integer to, BigDecimal count);
}
