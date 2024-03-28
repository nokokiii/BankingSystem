package accountTests.SavingAccount;

import accounts.SavingsAccount;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransferTests {
    private SavingsAccount account;
    private SavingsAccount account2;

    @Test
    public void testTransfer() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account2 = new SavingsAccount(1000.0, 0.01);
        this.account.transfer(this.account2, 50.0);
        assertEquals(950.0, this.account.getBalance(), 0.01);
        assertEquals(1050.0, this.account2.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferToNullAccount() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account.transfer(null, 50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferToSameAccount() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account.transfer(this.account, 50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferNegativeAmount() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account2 = new SavingsAccount(1000.0, 0.01);
        this.account.transfer(this.account2, -50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferInsufficientFunds() {
        this.account = new SavingsAccount(10.0, 0.01);
        this.account2 = new SavingsAccount(1000.0, 0.01);
        this.account.transfer(this.account2, 50.0);
    }

    @Test
    public void testTransferZero() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account2 = new SavingsAccount(1000.0, 0.01);
        this.account.transfer(this.account2, 0.0);
        assertEquals(1000.0, this.account.getBalance(), 0.01);
        assertEquals(1000.0, this.account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferMultiple() {
        this.account = new SavingsAccount(1000.0, 0.01);
        this.account2 = new SavingsAccount(1000.0, 0.01);
        this.account.transfer(this.account2, 50.0);
        this.account.transfer(this.account2, 50.0);
        assertEquals(900.0, this.account.getBalance(), 0.01);
        assertEquals(1100.0, this.account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferLargeAmount() {
        this.account = new SavingsAccount(300000.0, 0.01);
        this.account2 = new SavingsAccount(1000.0, 0.01);
        this.account.transfer(this.account2, 100000.0);
        assertEquals(200000.0, this.account.getBalance(), 0.01);
        assertEquals(101000.0, this.account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferToSavingsAccount() {
        this.account = new SavingsAccount(1000.0, 0.01);
        SavingsAccount account2 = new SavingsAccount(1000.0, 0.01);
        this.account.transfer(account2, 50.0);
        assertEquals(950.0, this.account.getBalance(), 0.01);
        assertEquals(1050.0, account2.getBalance(), 0.01);
    }
}
