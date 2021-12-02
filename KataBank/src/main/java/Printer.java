import java.time.format.DateTimeFormatter;
import java.util.List;

public class Printer {
    public static void printAccountStatement(Client client) {
        List<Operation> operations = client.getBankAccount().getUnmodifiableOperations();
        List<Integer> balances = client.getBankAccount().getAccountBalanceList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        int balance = 0;

        System.out.println(" Operation  | Date and time       | Amount     | Balance    \n" +
                "----------------------------------------------------------");
        for (int i = 0; i < operations.size(); i++) {
            balance += balances.get(i);
            System.out.println(String.format(" %s %s | %s | %d %s | %d", operations.get(i).getOperationType(),
                    printSpaces(operations.get(i).getOperationType()), operations.get(i).getOperationDate().format(formatter),
                    operations.get(i).getAmount(), printSpaces(operations.get(i).getAmount()), balance));
        }
    }

    private static String printSpaces(Object elem) {
        int elemLength = elem.toString().length();
        String spaces = "";

        for (int i = 0; i <= 8 - elemLength; i++) {
            spaces += " ";
        }
        return spaces;
    }
}
