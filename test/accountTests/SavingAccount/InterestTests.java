package accountTests.SavingAccount;

import accounts.SavingsAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InterestTests {
    private SavingsAccount account;

    @Test
    public void testAddInterest() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account.addInterest();
        assertEquals(1010.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testTransferInterest() {
        this.account = new SavingsAccount(1000.0, 0.01);
        SavingsAccount account2 = new SavingsAccount(1000.0, 0.01);
        this.account.transferInterest(account2);
        assertEquals(1010.0, account2.getBalance(), 0.01);
    }
}
