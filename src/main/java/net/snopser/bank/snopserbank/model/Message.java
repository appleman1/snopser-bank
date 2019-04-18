package net.snopser.bank.snopserbank.model;

import lombok.AllArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@AllArgsConstructor(access = PRIVATE)
public class Message {
    /**
     * код сообщения
     */
    private final String code;
    /**
     * аргумент сообщения
     */
    private final Object[] args;

    public static Message message(String code, Object... args) {
        return new Message(code, args);
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return args;
    }
}
