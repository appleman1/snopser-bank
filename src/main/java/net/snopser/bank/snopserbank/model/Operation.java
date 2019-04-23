package net.snopser.bank.snopserbank.model;

import lombok.Getter;
import net.snopser.bank.snopserbank.entity.Client;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Виктор Фалькенберг
 */
@Getter
public class Operation {
    private Client client;
    private final BigInteger senderAccount;
    private final BigInteger recieverAccount;
    private final BigDecimal count;


    public Operation(Client client, BigInteger senderAccount, BigInteger recieverAccount, BigDecimal count) {
        this.client = client;
        this.senderAccount = senderAccount;
        this.recieverAccount = recieverAccount;
        this.count = count;
    }

    public Operation setClient(Client client) {
        this.client = client;
        return this;
    }
}
