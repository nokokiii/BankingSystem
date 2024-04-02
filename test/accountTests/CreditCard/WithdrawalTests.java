package accountTests.CreditCard;

import accounts.CreditCard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WithdrawalTests {
    private CreditCard account;

    @Test
    public void testWithdrawal() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.withdraw(50.0);
        assertEquals(950.0, this.account.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalNegative() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.withdraw(-50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawalInsufficientFunds() {
        this.account = new CreditCard(10.0, 1000.0);
        this.account.withdraw(2000.0);
    }

    @Test
    public void testWithdrawalZero() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.withdraw(0.0);
        assertEquals(1000.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawalMultiple() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.withdraw(50.0);
        this.account.withdraw(50.0);
        assertEquals(900.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawalLargeAmount() {
        this.account = new CreditCard(200000.0, 1000.0);
        this.account.withdraw(100000.0);
        assertEquals(100000.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testWithdrawalDebt() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.withdraw(1500.0);
        assertEquals(0.0, this.account.getBalance(), 0.01);
    }
}
