package accountTests.CreditCard;

import accounts.CreditCard;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PayOffTests {
    private CreditCard account;

    @Test
    public void testPayOff() {
        account = new CreditCard(0, 100);
        account.withdraw(100);
        account.payOff(50);
        assertEquals(50, account.getDebt(), 0.01);
        assertEquals(0, account.getBalance(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPayOffNegativeAmount() {
        account = new CreditCard(100, 100);
        account.payOff(-50);
    }

    @Test
    public void testPayOffMoreThanDebt() {
        account = new CreditCard(0, 100);
        account.withdraw(100);
        account.payOff(150);
        assertEquals(0, account.getDebt(), 0.01);
        assertEquals(50, account.getBalance(), 0.01);
    }
}
