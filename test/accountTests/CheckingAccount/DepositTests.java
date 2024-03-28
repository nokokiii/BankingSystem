package accountTests.CheckingAccount;

import accounts.CheckingAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DepositTests {
    private CheckingAccount account;

    // Test deposit
    @Test
    public void testDeposit() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.deposit(50.0);
        assertEquals(1050.0, this.account.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegative() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.deposit(-50.0);
    }

    @Test
    public void testDepositZero() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.deposit(0.0);
        assertEquals(1000.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testDepositMultiple() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.deposit(50.0);
        this.account.deposit(50.0);
        assertEquals(1100.0, this.account.getBalance(), 0.01);
    }

    @Test
    public void testDepositLargeAmount() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.deposit(100000.0);
        assertEquals(101000.0, this.account.getBalance(), 0.01);
    }
}

