public class Client {
    private BankAccount account;

    public Client(BankAccount account) {
        this.account = account;
    }

    public void deposit(int amount) {
        this.account.addOperation(new DepositOperation(amount));
    }

    public void withdraw(int amount) {
        this.account.addOperation(new WithdrawOperation(amount));
    }

    public BankAccount getBankAccount() {
        return this.account;
    }
}
