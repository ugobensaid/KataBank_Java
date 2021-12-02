import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BankAccountShould {

    @Test
    public void return_an_empty_list_operation() {
        final BankAccount bankAccount = new BankAccount();
        assertEquals(0, bankAccount.getUnmodifiableOperations().size());
    }

    @Test
    public void return_an_list_with_one_operation() {
        final BankAccount bankAccount = new BankAccount();

        bankAccount.addOperation(new DepositOperation(200));
        assertEquals(1, bankAccount.getNumberOfOperations());
    }

    @Test
    public void return_account_balance_after_some_operations() {
        final BankAccount bankAccount = new BankAccount();

        bankAccount.addOperation(new DepositOperation(300));
        bankAccount.addOperation(new WithdrawOperation(100));
        bankAccount.addOperation(new DepositOperation(50));

        int accountBalance = 0;
        for (int amount : bankAccount.getAccountBalanceList()) {
            accountBalance += amount;
        }
        assertEquals(250, accountBalance);
    }
}