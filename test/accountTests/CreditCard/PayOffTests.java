package accountTests.CreditCard;

import accounts.CreditCard;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class PayOffTests {
    private CreditCard account;

    @Test
    public void testPayOff() {
        account = new CreditCard(100, 100);
        account.payOff(50);
        assertEquals(150, account.getDebt(), 0.001);
    }

    @Test
    public void testPayOffNegativeAmount() {
        account = new CreditCard(100, 100);
        try {
            account.payOff(-50);
        } catch (IllegalArgumentException e) {
            assertEquals(100, account.getDebt(), 0.001);
        }
    }

    @Test
    public void testPayOffMoreThanDebt() {
        account = new CreditCard(100, 100);
        account.payOff(150);
        assertEquals(0, account.getDebt(), 0.001);
        assertEquals(50, account.getBalance(), 0.001);
    }
}
