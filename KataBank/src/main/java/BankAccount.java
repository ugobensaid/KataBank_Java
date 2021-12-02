import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private final List<Operation> operations;

    public BankAccount() {
        operations = new ArrayList<>();
    }

    public void addOperation(Operation operation) {
        operations.add(operation);
    }

    public List<Integer> getAccountBalanceList() {
        List<Integer> balances = new ArrayList<>();

        for (int i = 0; i < operations.size(); i++) {
            Operation operation = operations.get(i);
            if (operation instanceof WithdrawOperation)
                balances.add(-1 * operation.getAmount());
            else
                balances.add(operation.getAmount());
        }
        return balances;
    }

    public List<Operation> getUnmodifiableOperations() {
        return Collections.unmodifiableList(operations);
    }

    public int getNumberOfOperations() {
        return operations.size();
    }
}
