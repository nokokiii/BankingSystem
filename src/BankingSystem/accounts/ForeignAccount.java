package BankingSystem.accounts;

import BankingSystem.currency.Currency;
import BankingSystem.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ForeignAccount extends CheckingAccount {
    private final Currency currency;
    private List<Transaction> transactions = new ArrayList<>();

    public ForeignAccount(double balance, String pin, double transferFee, double withdrawalFee, double withdrawalLimit, double transferLimit, Currency currency) {
        super(balance, pin, transferFee, withdrawalFee, withdrawalLimit, transferLimit);
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
        transactions.add(new Transaction("Out", account, amount));
    }

    // Getters
    public double getConvertedBalance() {
        return this.currency.getConvectedAmount(this.balance);
    }

    public Currency getCurrency() {
        return this.currency;
    }
}
