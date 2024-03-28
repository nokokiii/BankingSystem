package accountTests.CheckingAccount;

import accounts.CheckingAccount;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GettersTests {
    private CheckingAccount account;

    @Before
    public void setUp() {
        account = new CheckingAccount(100, 0.01, 0.01, 100, 100);
    }

    @Test
    public void testGetTransferFee() {
        assertEquals(0.01, account.getTransferFee(), 0.001);
    }

    @Test
    public void testGetWithdrawalFee() {
        assertEquals(0.01, account.getWithdrawalFee(), 0.001);
    }

    @Test
    public void testGetTransferLimit() {
        assertEquals(100, account.getTransferLimit(), 0.001);
    }

    @Test
    public void testGetBalance() {
        assertEquals(100, account.getBalance(), 0.001);
    }
}
