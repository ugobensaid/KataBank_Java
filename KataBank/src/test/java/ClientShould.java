import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
public class ClientShould {

    @Mock
    private BankAccount bankAccount;

    private Client client;


    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        client = new Client(bankAccount);
    }

    @Test
    public void make_one_operation() {
        client.deposit(200);
        client.withdraw(100);
        verify(bankAccount, times(2)).addOperation(any(Operation.class));
    }
}
