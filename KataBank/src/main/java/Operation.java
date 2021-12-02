import java.time.LocalDateTime;

public class Operation {
    private LocalDateTime operationDate;
    private int amount;
    private String operationType;

    public Operation(int amount, String operationType) {
        this.amount = amount;
        this.operationDate = LocalDateTime.now();
        this.operationType = operationType;
    }

    public LocalDateTime getOperationDate() {
        return this.operationDate;
    }

    public int getAmount() {
        return this.amount;
    }

    public String getOperationType() {
        return this.operationType;
    }
}
