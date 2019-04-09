package net.snopser.bank.snopserbank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @Column(name = "client_id")
    private UUID clientId;

    @Column(name = "bank_id")
    private UUID bankId;

    @Column(name = "fio")
    private String fio;

    public UUID getClientId() {
        return clientId;
    }

    public UUID getBankId() {
        return bankId;
    }

    public String getFio() {
        return fio;
    }
}
