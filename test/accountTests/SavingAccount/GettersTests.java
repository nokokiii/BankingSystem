package accountTests.SavingAccount;

import accounts.SavingsAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GettersTests {
    private SavingsAccount account;

    @Test
    public void testGetInterest() {
        this.account = new SavingsAccount(1000.0, 0.01);
        assertEquals(10.0, this.account.getInterest(), 0.01);
    }

    @Test
    public void testGetInterestRate() {
        this.account = new SavingsAccount(1000.0, 0.01);
        assertEquals(0.01, this.account.getInterestRate(), 0.01);
    }
}
