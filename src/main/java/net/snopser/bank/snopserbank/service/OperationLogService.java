package net.snopser.bank.snopserbank.service;

import net.snopser.bank.snopserbank.entity.OperationLog;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
public interface OperationLogService {
    void saveTransfer(List<OperationLog> logs);


}
