public class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        setInterestRate(interestRate);
    }

    // Interest methods
    public void addInterest() {
        this.balance += this.balance * this.interestRate;
    }

    public void transferInterest(BankAccount account) {
        validateBankAccount(account);
        account.deposit(getInterest());
    }

    // Setters
    public void setInterestRate(double interestRate) {
        if (interestRate < 0) {
            throw new IllegalArgumentException("Interest rate cannot be negative");
        }

        this.interestRate = interestRate;
    }

    // Getters
    public double getInterest() {
        return this.balance * this.interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }
}
