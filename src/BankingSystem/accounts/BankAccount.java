package BankingSystem.accounts;

import BankingSystem.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class BankAccount {
    private final String accountNumber;
    private final String pin;
    private final List<Transaction> transactions = new ArrayList<>();
    protected double balance;

    public BankAccount(double balance, String pin) {
        this.accountNumber = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 1000000));
        validateNonNegative(balance, "Balance cannot be negative");
        this.balance = balance;
        this.pin = pin;
    }

    protected void validateNonNegative(double value, String message) {
        if (value < 0) {
            throw new IllegalArgumentException(message);
        }
    }

    // Deposit methods
    protected void validateDeposit(double amount) {
        validateNonNegative(amount, "Amount cannot be negative");
    }

    protected void performDeposit(double amount) {
        this.balance += amount;
    }

    public void deposit(double amount) {
        validateDeposit(amount);
        performDeposit(amount);
    }

    // Withdrawal methods
    protected void validateWithdrawal(double amount) {
        validateNonNegative(amount, "Amount cannot be negative");
        if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    protected void performWithdrawal(double amount) {
        this.balance -= amount;
    }

    public void withdraw(double amount) {
        validateWithdrawal(amount);
        performWithdrawal(amount);
    }

    protected void validateBankAccount(BankAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        } else if (account == this) {
            throw new IllegalArgumentException("You cannot transfer to the same account");
        }
    }

    // Transfer methods
    protected void validateTransfer(BankAccount account, double amount) {
        validateBankAccount(account);
        validateWithdrawal(amount);
    }

    protected void performTransfer(BankAccount account, double amount) {
        performWithdrawal(amount);
        account.deposit(amount);
    }

    public void transfer(BankAccount account, double amount) {
        validateTransfer(account, amount);
        performTransfer(account, amount);
        addTransaction(new Transaction("Out", account, amount));
        account.addTransaction(new Transaction("In", this, amount));
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Getters

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getPin() {
        return this.pin;
    }

    @Override
    public String toString() {
        return accountNumber;
    }
}
