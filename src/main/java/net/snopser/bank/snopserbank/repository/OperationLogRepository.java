package net.snopser.bank.snopserbank.repository;

import net.snopser.bank.snopserbank.entity.OperationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * @author Виктор Фалькенберг
 */
public interface OperationLogRepository extends JpaRepository<OperationLog, UUID> {
}
