package accountTests.CreditCard;

import accounts.CreditCard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepositTests {
    private CreditCard account;

    @Test
    public void testDeposit() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.deposit(50.0);
        assertEquals(1050.0, this.account.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegative() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.deposit(-50.0);
    }

    @Test
    public void testDepositZero() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.deposit(0.0);
        assertEquals(1000.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testDepositMultiple() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.deposit(50.0);
        this.account.deposit(50.0);
        assertEquals(1100.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testDepositLargeAmount() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.deposit(100000.0);
        assertEquals(101000.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testDepositDebt() {
        this.account = new CreditCard(1000.0, 1000.0);
        this.account.withdraw(2000.0);
        this.account.deposit(500.0);
        assertEquals(0.00, this.account.getBalance(), 0.01);
        assertEquals(500.0, this.account.getDebt(), 0.01);
    }
}
