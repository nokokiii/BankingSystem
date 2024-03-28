package src.main.accounts;

import src.main.currency.Currency;

public class ForeignAccount extends checkingAccount {
    private final Currency currency;

    public ForeignAccount(double balance, double transferFee, double withdrawalFee, double withdrawalLimit, double transferLimit, Currency currency) {
        super(balance, transferFee, withdrawalFee, withdrawalLimit, transferLimit);
        this.currency = currency;
    }

    // Deposit methods
    @Override
    protected void performDeposit(double amount) {
        this.balance += amount * this.currency.getExchangeRate();
    }

    // Withdrawal methods
    @Override
    protected void validateWithdrawal(double amount) {
        validateNonNegative(amount, "Amount cannot be negative");
        double transferFee = amount * this.transferFee;
        double convectedAmount = this.currency.getConvectedAmount(amount);
        if (convectedAmount + transferFee > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        } else if (convectedAmount > this.withdrawalLimit) {
            throw new IllegalArgumentException("Amount exceeds maximum withdrawal amount");
        }
    }

    @Override
    protected void performWithdrawal(double amount) {
        double transferFee = amount * this.transferFee;
        this.balance -= this.currency.getConvectedAmount(amount) + transferFee;
    }

    // Transfer methods
    @Override
    public void transfer(BankAccount account, double amount) {
        validateTransfer(account, amount);
        performTransfer(account, amount);
    }

    // Getters
    public double getConvertedBalance() {
        return this.currency.getConvectedAmount(this.balance);
    }

    public Currency getCurrency() {
        return this.currency;
    }
}
