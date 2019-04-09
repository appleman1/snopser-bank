package net.snopser.bank.snopserbank.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "operation_logs")
public class OperationLog {

    @Id
    @Column(name = "operation_id")
    private UUID operationId;

    @Column (name = "start_date")
    private LocalDateTime startDate;

    @Column (name = "end_date")
    private LocalDateTime endDate;

    @Column (name = "account_id")
    private int accountId;

    @Column (name = "operation_type_id")
    private int operationType;

    @Column (name = "status_id")
    private int statusId;

    public UUID getOperationId() {
        return operationId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public int getAccountId() {
        return accountId;
    }

    public int getOperationType() {
        return operationType;
    }

    public int getStatusId() {
        return statusId;
    }
}
