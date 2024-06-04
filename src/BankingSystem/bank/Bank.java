package BankingSystem.bank;

import BankingSystem.accounts.*;
import BankingSystem.currency.Currency;

import java.util.HashMap;
import java.util.Objects;

/**
 * This is the Bank class that will store all accounts created in this bank. Banks Can have different fees and limits
 */
public class Bank {
    public String name;
    public HashMap<String, BankAccount> accounts = new HashMap<>();

    // Bank params
    private final double transferFee;
    private final double withdrawalFee;
    private final double withdrawalLimit;
    private final double transferLimit;
    private final double interestRate;
    private final double creditLimit;


    public Bank(String name, double transferFee, double withdrawalFee, double withdrawalLimit, double transferLimit, double interestRate, double creditLimit) {
        this.name = name;
        this.transferFee = transferFee;
        this.withdrawalFee = withdrawalFee;
        this.withdrawalLimit = withdrawalLimit;
        this.transferLimit = transferLimit;
        this.interestRate = interestRate;
        this.creditLimit = creditLimit;
    }

    /**
     * Login to the bank
     * @param bankNumber The bank number of the account
     * @param pin The pin of the account
     * @return The account if the login is successful, otherwise `null`
     */
    public BankAccount login(String bankNumber, String pin) {
        if (this.accounts.containsKey(bankNumber)) {
            BankAccount account = this.accounts.get(bankNumber);
            if (Objects.equals(account.getPin(), pin)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Find the account in the bank
     * @param bankNumber The bank number of the account
     * @return The account if found, otherwise `null`
     */
    public BankAccount findAccount(String bankNumber) {
        return this.accounts.getOrDefault(bankNumber, null);
    }

    /**
     * Create a checking account
     * @param pin The pin of the account
     * @return The created checking account
     */
    public CheckingAccount createCheckingAccount(String pin) {
        CheckingAccount account = new CheckingAccount(0.0, pin, this.transferFee, this.withdrawalFee, this.withdrawalLimit, this.transferLimit);
        this.accounts.put(account.toString(), account);
        return account;
    }

    /**
     * Create a foreign account
     * @param pin The pin of the account
     * @param currency The currency of the account
     * @return The created foreign account
     */
    public ForeignAccount createForeignAccount(String pin, Currency currency) {
        ForeignAccount account = new ForeignAccount(0.0, pin, this.transferFee, this.withdrawalFee, this.withdrawalLimit, this.transferLimit, currency);
        this.accounts.put(account.toString(), account);
        return account;
    }

    /**
     * Create a savings account
     * @param pin The pin of the account
     * @return The created savings account
     */
    public SavingsAccount createSavingsAccount(String pin) {
        SavingsAccount account = new SavingsAccount(0.0, pin, this.interestRate);
        this.accounts.put(account.toString(), account);
        return account;
    }

    /**
     * Create a credit account
     * @param pin The pin of the account
     * @return The created credit account
     */
    public CreditCard createCreditAccount(String pin) {
        CreditCard account = new CreditCard(0.0, pin, this.creditLimit);
        this.accounts.put(account.toString(), account);
        return account;
    }
}
