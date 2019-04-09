package net.snopser.bank.snopserbank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="banks")
public class Bank {
    @Id
    @Column(name="bank_id")
    private UUID bankId;

    @Column(name="name")
    private String name;

    @Column(name="code")
    private int code;

    public UUID getBankId() {
        return bankId;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }
}
