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
    @Nullable
    private final String login;
    @Nullable
    private final UUID profileId;
    private final List<String> messages;

    private Result(String login, UUID profileId, List<String> messages) {
        this.login = login;
        this.profileId = profileId;
        this.messages = messages;
    }


}
