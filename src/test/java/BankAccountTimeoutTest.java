import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;

@Timeout(value = 3000, unit = TimeUnit.MILLISECONDS)
@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountTimeoutTest {
    @Test
    public void testDepositTimeoutAssertion(BankAccount bankAccount) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bankAccount.deposit(100);
        assertEquals(100, bankAccount.getBalance());
    }

    @Test
    public void testDepositTimeoutAnnotationAssertion(BankAccount bankAccount) {   try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
        bankAccount.deposit(100);
        assertTimeout(Duration.ofMillis(500), () -> {
            Thread.sleep(200);
        });
    }
}
