package net.snopser.bank.snopserbank.exception;

/**
 * @author Виктор Фалькенберг
 */
public class UnknownException extends ErrorException {

    private static String CODE = "snopser-bank.exception.error.unknown";

    protected UnknownException(Object... args) {
        super(CODE, args);
    }

    protected UnknownException(Throwable cause, Object... args) {
        super(cause, CODE, args);
    }
}
