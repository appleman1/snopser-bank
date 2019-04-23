package net.snopser.bank.snopserbank.entity;

import net.snopser.bank.snopserbank.model.OperationType;
import net.snopser.bank.snopserbank.model.Status;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "operation_logs")
public class OperationLog {

    @Id
    @Column(name = "operation_id")
    private UUID operationId;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "account_id")
    private BigInteger accountId;

    @Column(name = "operation_type_id")
    @Enumerated(EnumType.STRING)
    private OperationType operationType;

    @Column(name = "status_id")
    @Enumerated(EnumType.STRING)
    private Status statusId;

    public OperationLog() {
    }

    public OperationLog(BigInteger accountId, OperationType operationType) {
        this.operationId = UUID.randomUUID();
        this.startDate = LocalDateTime.now();
        this.endDate = null;
        this.accountId = accountId;
        this.operationType = operationType;
        this.statusId = Status.IN_PROCESS;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }
}
