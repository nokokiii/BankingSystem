public class Main {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("123456", 1000);
        savingsAccount.addInterest();
        assert savingsAccount.checkBalance() == 1000;

        savingsAccount.deposit(100);
        assert savingsAccount.checkBalance() == 1100;
    }
}
