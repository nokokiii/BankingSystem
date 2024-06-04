package BankingSystem.transaction;

import BankingSystem.accounts.BankAccount;

public record Transaction(String type, BankAccount account, double amount) {}
