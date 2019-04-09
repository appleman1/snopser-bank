package net.snopser.bank.snopserbank.service.implementation;

import net.snopser.bank.snopserbank.repository.OperationLogRepository;
import net.snopser.bank.snopserbank.service.OperationLogService;
import org.springframework.stereotype.Service;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@Service
public class DefaultOperationLogService implements OperationLogService {
    private final OperationLogRepository operationLogRepository;

    public DefaultOperationLogService(OperationLogRepository operationLogRepository) {
        this.operationLogRepository = operationLogRepository;
    }
}
