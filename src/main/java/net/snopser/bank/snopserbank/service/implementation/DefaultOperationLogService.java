package net.snopser.bank.snopserbank.service.implementation;

import net.snopser.bank.snopserbank.entity.OperationLog;
import net.snopser.bank.snopserbank.repository.OperationLogRepository;
import net.snopser.bank.snopserbank.service.OperationLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Виктор Фалькенберг (viktor.falkenberg@mediascope.net)
 */
@Service
public class DefaultOperationLogService implements OperationLogService {
    private final OperationLogRepository operationLogRepository;

    public DefaultOperationLogService(OperationLogRepository operationLogRepository) {
        this.operationLogRepository = operationLogRepository;
    }

    @Override
    @Transactional
    public void saveTransfer(List<OperationLog> logs) {
        operationLogRepository.saveAll(logs);
    }
}
