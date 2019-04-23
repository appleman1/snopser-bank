package net.snopser.bank.snopserbank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @Column(name = "account_id")
    private BigInteger accountId;

    @Column(name = "bank_id")
    private int bankId;

    @Column(name = "count")
    private BigDecimal count;

    @Column(name = "client_id")
    private UUID clientId;

    public BigInteger getAccountId() {
        return accountId;
    }

    public int getBankId() {
        return bankId;
    }

    public BigDecimal getCount() {
        return count;
    }

    public UUID getClientId() {
        return clientId;
    }

    public Account setAccountId(BigInteger accountId) {
        this.accountId = accountId;
        return this;
    }

    public Account setBankId(int bankId) {
        this.bankId = bankId;
        return this;
    }

    public Account setCount(BigDecimal count) {
        this.count = count;
        return this;
    }

    public Account setClientId(UUID clientId) {
        this.clientId = clientId;
        return this;
    }
}
