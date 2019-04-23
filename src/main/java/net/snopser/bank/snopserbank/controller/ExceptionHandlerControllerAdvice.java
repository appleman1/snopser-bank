package net.snopser.bank.snopserbank.controller;

import net.snopser.bank.snopserbank.exception.ErrorException;
import net.snopser.bank.snopserbank.exception.TransferErrorException;
import net.snopser.bank.snopserbank.exception.UnknownException;
import net.snopser.bank.snopserbank.repository.OperationLogRepository;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Locale;

import static java.util.Collections.singletonList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.ResponseEntity.status;

/**
 * Контроллер для перехвата исключений
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice implements MessageSourceAware {

    private MessageSource messageSource;
    private final OperationLogRepository operationLogRepository;

    public ExceptionHandlerControllerAdvice(OperationLogRepository operationLogRepository) {
        this.operationLogRepository = operationLogRepository;
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<List<String>> handle(ErrorException ex, Locale locale) {
        HttpStatus httpStatus = ex instanceof UnknownException ? INTERNAL_SERVER_ERROR : BAD_REQUEST;
        String message = messageSource.getMessage(ex.getMessage(), ex.getArgs(), locale);
        return status(httpStatus).body(singletonList(message));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<List<String>> handle(DataIntegrityViolationException ex, Locale locale) {
        return status(CONFLICT)
                .body(
                        singletonList(
                                messageSource.getMessage(
                                        "snopser-bank.exception.error.data-integrity-violation",
                                        null,
                                        locale)
                        )
                );
    }

    @ExceptionHandler(TransferErrorException.class)
    public ResponseEntity<List<String>> handle(TransferErrorException ex, Locale locale) {
        operationLogRepository.saveAll(ex.getLogList());
        return status(CONFLICT)
                .body(
                        singletonList(
                                messageSource.getMessage(
                                        "snopser-bank.exception.error.transfer",
                                        null,
                                        locale)
                        )
                );
    }
}
