package net.snopser.bank.snopserbank.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@Getter
public class Operation {
    private final BigInteger senderAccount;
    private final BigInteger recieverAccount;
    private final BigDecimal count;


    public Operation(BigInteger senderAccount, BigInteger recieverAccount, BigDecimal count) {
        this.senderAccount = senderAccount;
        this.recieverAccount = recieverAccount;
        this.count = count;
    }
}
