package accountTests.SavingAccount;

import BankingSystem.accounts.SavingsAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SettersTests {
    @Test
    public void testSetInterestRate() {
        SavingsAccount account = new SavingsAccount(1000.0, 0.01);
        account.setInterestRate(0.02);
        assertEquals(0.02, account.getInterestRate(), 0.01);
    }
}
