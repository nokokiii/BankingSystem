package accountTests.SavingAccount;

import accounts.SavingsAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WithdrawalTests {
    private SavingsAccount account;

    @Test
    public void testWithdraw() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account.withdraw(50.0);
        assertEquals(950.0, this.account.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegative() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account.withdraw(-50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        this.account = new SavingsAccount(10.0, 0.01);
        this.account.withdraw(50.0);
    }

    @Test
    public void testWithdrawZero() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account.withdraw(0.0);
        assertEquals(1000.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawMultiple() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account.withdraw(50.0);
        this.account.withdraw(50.0);
        assertEquals(900.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawLargeAmount() {
        this.account = new SavingsAccount(200000.0, 0.01);
        this.account.withdraw(100000.0);
        assertEquals(100000.0, this.account.getBalance(), 0.01);
    }
}
