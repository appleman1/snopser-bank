package net.snopser.bank.snopserbank.exception;

import lombok.Getter;

/**
 * @author Виктор Фалькенберг
 */
@Getter
public abstract class ErrorException extends RuntimeException {
    private final String code;

    private final Object[] args;

    protected ErrorException(String code, Object... args) {
        super();
        this.code = code;
        this.args = args;
    }

    protected ErrorException(Throwable cause, String code, Object... args) {
        super(cause);
        this.code = code;
        this.args = args;
    }
}
