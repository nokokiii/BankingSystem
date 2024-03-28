package accountTests.CheckingAccount;

import accounts.CheckingAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransferTests {
    private CheckingAccount account;
    private CheckingAccount account2;

    @Test
    public void testTransfer() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account2 = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.transfer(this.account2, 50.0);
        assertEquals(949.5, this.account.getBalance(), 0.01);
        assertEquals(1050.0, this.account2.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferToNullAccount() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.transfer(null, 50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferToSameAccount() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.transfer(this.account, 50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferNegativeAmount() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account2 = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.transfer(this.account2, -50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferInsufficientFunds() {
        this.account = new CheckingAccount(10.0, 0.01, 0.05, 200.0, 100.0);
        this.account2 = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.transfer(this.account2, 50.0);
    }

    @Test
    public void testTransferZero() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account2 = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.transfer(this.account2, 0.0);
        assertEquals(1000.0, this.account.getBalance(), 0.01);
        assertEquals(1000.0, this.account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferMultiple() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account2 = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.transfer(this.account2, 50.0);
        this.account.transfer(this.account2, 50.0);
        assertEquals(899.0, this.account.getBalance(), 0.01);
        assertEquals(1100.0, this.account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferLargeAmount() {
        this.account = new CheckingAccount(300000.0, 0.01, 0.05, 200.0, 10000000.0);
        this.account2 = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.transfer(this.account2, 100000.0);
        assertEquals(199000.0, this.account.getBalance(), 0.01);
        assertEquals(101000.0, this.account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferToCheckingAccount() {
        this.account = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        CheckingAccount account2 = new CheckingAccount(1000.0, 0.01, 0.05, 200.0, 100.0);
        this.account.transfer(account2, 50.0);
        assertEquals(949.5, this.account.getBalance(), 0.01);
        assertEquals(1050.0, account2.getBalance(), 0.01);
    }
}
