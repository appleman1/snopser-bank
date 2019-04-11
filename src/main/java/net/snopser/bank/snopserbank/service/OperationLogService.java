package net.snopser.bank.snopserbank.service;

import net.snopser.bank.snopserbank.entity.OperationLog;

import java.util.List;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
public interface OperationLogService {
    void saveTransfer(List<OperationLog> logs);
}
