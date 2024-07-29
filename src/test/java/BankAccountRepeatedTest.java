import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepeatedTest {
    @RepeatedTest(5)
    @DisplayName("Deposit 300 successfully")
    public void testDeposit(BankAccount bankAccount) {
        bankAccount.deposit(300);
        assertEquals(300, bankAccount.getBalance());

    }

    @RepeatedTest(5)
    @DisplayName("Deposit 300 successfully")
    public void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
        int deposit = repetitionInfo.getCurrentRepetition() * 300;
        bankAccount.deposit(deposit);
        assertEquals(repetitionInfo.getCurrentRepetition() * 300, bankAccount.getBalance());
        System.out.println(deposit);
    }
}
