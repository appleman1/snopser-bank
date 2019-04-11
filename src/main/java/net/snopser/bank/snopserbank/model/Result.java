package net.snopser.bank.snopserbank.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.UUID;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@EqualsAndHashCode()
@Data
@Builder
public class Result {

    private final List<String> messages;

    private Result(List<String> messages) {
        this.messages = messages;
    }
}
