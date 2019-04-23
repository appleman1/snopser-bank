package net.snopser.bank.snopserbank.exception;

import net.snopser.bank.snopserbank.entity.OperationLog;

import java.util.List;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
public class TransferErrorException extends ErrorException {

    private final static String CODE = "snopser-bank.exception.error.transfer";

    private final List<OperationLog> logList;

    public TransferErrorException(Throwable cause, List<OperationLog> logList) {
        super(cause, CODE);
        this.logList = logList;
    }

    public TransferErrorException(List<OperationLog> logList) {
        super(CODE);
        this.logList = logList;
    }

    public List<OperationLog> getLogList() {
        return logList;
    }
}
