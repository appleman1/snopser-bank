package net.snopser.bank.snopserbank.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;
import java.util.List;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@EqualsAndHashCode()
@Data
@Builder
public class Result {
    private final String clientLogin;
    private final Collection<String> messages;

    private Result(String clientLogin, Collection<String> messages) {
        this.clientLogin = clientLogin;
        this.messages = messages;
    }
}
