public class Main {

    public static void main(String[] args) {
        Client client = new Client(new BankAccount());

        client.deposit(2500);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client.withdraw(500);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client.deposit(50);
        Printer.printAccountStatement(client);
    }
}

