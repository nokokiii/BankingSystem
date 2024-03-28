package accounts;

public class CreditCard extends BankAccount {
    private double creditLimit;
    private double debt;

    public CreditCard(double balance, double creditLimit) {
        super(balance);
        setCreditLimit(creditLimit);
    }

    // Deposit methods
    @Override
    protected void performDeposit(double amount) {
        if (this.debt > 0) {
            if (amount >= this.debt) {
                amount -= this.debt;
                this.debt = 0;
            } else {
                this.debt -= amount;
                return;
            }
        }

        this.balance += amount;
    }

    // Withdrawal methods
    @Override
    protected void validateWithdrawal(double amount) {
        validateNonNegative(amount, "Amount cannot be negative");
        if (amount > balance + creditLimit - debt) {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    @Override
    protected void performWithdrawal(double amount) {
        if (amount > this.balance + this.creditLimit - this.debt) {
            throw new IllegalArgumentException("Insufficient funds");
        } else if (amount > this.balance) {
            this.debt += amount - this.balance;
            this.balance = 0;
        } else {
            this.balance -= amount;
        }
    }

    // Credit payoff methods
    public void payOff(double amount) {
        validateNonNegative(amount, "Amount cannot be negative");
        if (amount > this.debt) {
            this.balance += amount - this.debt;
            this.debt = 0;
        } else {
            this.debt -= amount;
        }
    }

    // Setters
    private void setCreditLimit(double creditLimit) {
        validateNonNegative(creditLimit, "Credit limit cannot be negative");
        this.creditLimit = creditLimit;
    }

    // Getters
    public double getCreditLimit() {
        return this.creditLimit;
    }

    public double getDebt() {
        return this.debt;
    }
}
