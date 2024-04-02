package accountTests.CreditCard;

import accounts.CreditCard;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransferTests {
    private CreditCard account1;
    private CreditCard account2;

    @Test
    public void testTransfer() {
        this.account1 = new CreditCard(1000.0, 200.0);
        this.account2 = new CreditCard(1000.0, 200.0);
        this.account1.transfer(this.account2, 50.0);
        assertEquals(950.0, this.account1.getBalance(), 0.01);
        assertEquals(1050.0, this.account2.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferToNullAccount() {
        this.account1 = new CreditCard(1000.0, 200.0);
        this.account1.transfer(null, 50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferToSameAccount() {
        this.account1 = new CreditCard(1000.0, 200.0);
        this.account1.transfer(this.account1, 50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferNegativeAmount() {
        this.account1 = new CreditCard(1000.0, 200.0);
        this.account2 = new CreditCard(1000.0, 200.0);
        this.account1.transfer(this.account2, -50.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTransferInsufficientFunds() {
        this.account1 = new CreditCard(10.0, 100.0);
        this.account2 = new CreditCard(1000.0, 200.0);
        this.account1.transfer(this.account2, 150.0);
    }

    @Test
    public void testTransferZero() {
        this.account1 = new CreditCard(1000.0, 200.0);
        this.account2 = new CreditCard(1000.0, 200.0);
        this.account1.transfer(this.account2, 0.0);
        assertEquals(1000.0, this.account1.getBalance(), 0.01);
        assertEquals(1000.0, this.account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferMultiple() {
        this.account1 = new CreditCard(1000.0, 200.0);
        this.account2 = new CreditCard(1000.0, 200.0);
        this.account1.transfer(this.account2, 50.0);
        this.account1.transfer(this.account2, 50.0);
        assertEquals(900.0, this.account1.getBalance(), 0.01);
        assertEquals(1100.0, this.account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferDebt() {
        this.account1 = new CreditCard(1000.0, 200.0);
        this.account2 = new CreditCard(1000.0, 200.0);
        this.account1.withdraw(1100.0);
        this.account1.transfer(this.account2, 50.0);
        assertEquals(0.0, this.account1.getBalance(), 0.01);
        assertEquals(1050.0, this.account2.getBalance(), 0.01);
    }

    @Test
    public void testTransferDebtMultiple() {
        this.account1 = new CreditCard(1000.0, 200.0);
        this.account2 = new CreditCard(1000.0, 200.0);
        this.account1.withdraw(1100.0);
        this.account1.transfer(this.account2, 50.0);
        this.account1.transfer(this.account2, 50.0);
        assertEquals(0.0, this.account1.getBalance(), 0.01);
        assertEquals(1100.0, this.account2.getBalance(), 0.01);
    }
}
