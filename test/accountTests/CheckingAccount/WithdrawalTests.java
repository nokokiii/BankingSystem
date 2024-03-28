package accountTests.CheckingAccount;

import accounts.CheckingAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WithdrawalTests {
    private CheckingAccount account;

    @Test
    public void testWithdraw() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.withdraw(50.0);
        assertEquals(949.5, this.account.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegative() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.withdraw(-50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawInsufficientFunds() {
        this.account = new CheckingAccount(10.0, 0.01, 0.05, 200.0, 100.0);
        this.account.withdraw(50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawExceedsLimit() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.withdraw(201.0);
    }

    @Test
    public void testWithdrawZero() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.withdraw(0.0);
        assertEquals(1000.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawMultiple() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.withdraw(50.0);
        this.account.withdraw(50.0);
        assertEquals(899.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawLargeAmount() {
        this.account = new CheckingAccount(200000.0, 0.01, 0.05, 200000.0, 100.0);
        this.account.withdraw(100000.0);
        assertEquals(99000.0, this.account.getBalance(), 0.01);
    }
}
