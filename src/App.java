import BankingSystem.bank.Bank;
import BankingSystem.accounts.BankAccount;
import BankingSystem.transaction.Transaction;
import BankingSystem.currency.Currency;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public HashMap<String, Bank> banks = new HashMap<>();
    public HashMap<String, Currency> currencies = new HashMap<>();
    public Scanner scanner = new Scanner(System.in);

    public App() {
        createBank("mBank", 0.01, 0.02, 5000.0, 100000.0, 0.05, 10000.0);
        createBank("Santander", 0.02, 0.03, 4000.0, 90000.0, 0.04, 8000.0);
        createBank("VeloBank",  0.03, 0.03, 8000.0, 150000.0, 0.07, 9000.0);

        createCurrency("CNY", 0.15);
        createCurrency("EUR", 1.12);
        createCurrency("GBP", 0.75);
    }

    // Generators

    /**
     * Create a currency and put it in the currencies map
     * @param code The code of the currency
     * @param exchangeRate The exchange rate of the currency
     */
    public void createCurrency(String code, double exchangeRate) {
    //        currencies.put(code, Currency.getInstance(code));
    }

    /**
     * This method creates a bank and puts it in the banks map
     * @param name The name of the bank
     * @param transferFee The transfer fee of the bank
     * @param withdrawalFee The withdrawal fee of the bank
     * @param withdrawalLimit The withdrawal limit of the bank
     * @param transferLimit The transfer limit of the bank
     * @param interestRate The interest rate of the bank
     * @param creditLimit The credit limit of the bank
     */
    public void createBank(String name, double transferFee, double withdrawalFee, double withdrawalLimit, double transferLimit, double interestRate, double creditLimit) {
        banks.put(name, new Bank(name, transferFee, withdrawalFee, withdrawalLimit, transferLimit, interestRate, creditLimit));
    }

    /**
    * Main method to start the application
     */
    public void start() {
        System.out.println("What would you like to do?");
        System.out.println("1. Create a bank account");
        System.out.println("2. Login to a bank account");
        System.out.println("3. Exit");

        Integer option = AppUtils.getIntInput(scanner, "Enter an option: ");

        Bank bank;
        switch (option) {
            case 1:
                bank = choseBank();
                createAccount(bank);
                break;
            case 2:
                bank = choseBank();
                login(bank);
                break;
            case 3:
                System.out.println("Goodbye!");
                break;
            case null:
                start();
                break;
            default:
                System.out.println("Invalid option");
                start();
        }
    }

    // TODO: Implement this in the BankMenu class for cleaner code

    /**
     * CLI menu for withdrawing money from an account.
      * @param account The account to withdraw from
     */
    public void withdraw(BankAccount account) {
        System.out.println("Enter the amount you would like to withdraw:");
        Double amount = AppUtils.getDoubleInput(scanner, "Enter the amount you would like to withdraw: ");

        if (amount == null) {
            withdraw(account);
        } else {
            try {
                account.withdraw(amount);
                System.out.println("Withdrawal successful");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            bankMenu(account);
        }
    }

    /**
     * CLI menu for depositing money into an account.
     * @param account The account to deposit into
     */
    public void deposit(BankAccount account) {
        Double amount = AppUtils.getDoubleInput(scanner, "Enter the amount you would like to deposit: ");

        if (amount == null) {
            deposit(account);
        } else {
            try {
                account.deposit(amount);
                System.out.println("Deposit successful");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            bankMenu(account);
        }
    }

    /**
     * CLI menu for transferring money between accounts.
     * @param account The account that money will be transferred to
     */
    public void transfer(BankAccount account) {
        Bank bank = choseBank();

        String bankNumber = AppUtils.getStringInput(scanner, "Enter the bank account number you would like to transfer to: ");
        Double amount = AppUtils.getDoubleInput(scanner, "Enter the amount you would like to transfer: ");

        if (amount == null) {
            transfer(account);
        } else {
            BankAccount toAccount = bank.findAccount(bankNumber);

            if (toAccount == null) {
                System.out.println("Account not found");
                bankMenu(account);
            } else {
                try {
                    account.transfer(toAccount, amount);
                    System.out.println("Transfer successful");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                bankMenu(account);
            }
        }
    }

    /**
     * CLI menu for writing the transaction history of an account.
     * @param account The account to write the transaction history of
     */
    public void writeTransactionHistory(BankAccount account) {
        System.out.println("Transaction history:");

        if (account.getTransactions().isEmpty()) {
            System.out.println("No transactions");
        } else {
            for (Transaction transaction : account.getTransactions()) {
                System.out.println(transaction.type() + " " + transaction.account().toString() + " " + transaction.amount());
            }
        }

        bankMenu(account);
    }

    /**
     * CLI menu for creating a bank account.
     * @param bank The bank to create the account in
     */
    public void createAccount(Bank bank) {
        System.out.println("Enter your pin:");
        String pin = scanner.nextLine();

        System.out.println("What type of bank account would you like to create?");
        System.out.println("1. Checking account");
        System.out.println("2. Foreign account");
        System.out.println("3. Savings account");
        System.out.println("4. Credit account");
        System.out.println("5. Out");
        Integer option = AppUtils.getIntInput(scanner, "Enter an option: ");

        switch (option) {
            case 1:
                bankMenu(bank.createCheckingAccount(pin));
                break;
            case 2:
                Currency currency = choseCurrency();
                bankMenu(bank.createForeignAccount(pin, currency));
                break;
            case 3:
                bankMenu(bank.createSavingsAccount(pin));
                break;
            case 4:
                bankMenu(bank.createCreditAccount(pin));
                break;
            case 5:
                start();
                break;
            case null:
                createAccount(bank);
                break;
            default:
                System.out.println("Invalid option");
                createAccount(bank);
        }
    }

    /**
     * CLI menu for the bank menu.
     * @param account The account to display the menu for
     */
    public void bankMenu(BankAccount account) {
        System.out.println("What would you like to do?");
        System.out.println("Account number: " + account.toString());
        System.out.println("Balance: " + account.getBalance());
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Transfer");
        System.out.println("4. Transfer history");
        System.out.println("5. Logout");

        Integer option = AppUtils.getIntInput(scanner, "Enter an option: ");

        switch (option) {
            case 1:
                withdraw(account);
                break;
            case 2:
                deposit(account);
                break;
            case 3:
                transfer(account);
                break;
            case 4:
                writeTransactionHistory(account);
                break;
            case 5:
                start();
                break;
            case null:
                bankMenu(account);
                break;
            default:
                System.out.println("Invalid option");
                bankMenu(account);
        }
    }

    // Utility
    // TODO: Maybe move this to a utility class as static methods but idk yet

    /**
     * CLI menu for logging into a bank account.
     * @param bank The bank to log into
     */
    public void login(Bank bank) {
        String bankNumber = AppUtils.getStringInput(scanner, "Enter your bank account number: ");
        String pin = AppUtils.getStringInput(scanner, "Enter your pin: ");

        BankAccount account = bank.login(bankNumber, pin);
        if (account != null) {
            System.out.println("Login successful");
            bankMenu(account);
        } else {
            System.out.println("Login failed");
            start();
        }
    }

    /**
     * CLI menu for choosing a currency
     * @return The chosen currency
     */
    public Currency choseCurrency() {
        System.out.println("Choose a currency:");
        int i = 1;
        for (String currency : currencies.keySet()) {
            System.out.println(i + ". " + currency);
            i++;
        }

        Integer option;
        try {
            option = AppUtils.getIntInput(scanner, "Enter an option: ");
        } catch (NoSuchElementException e) {
            System.out.println("No option was entered. Please enter a number from the list.");
            return choseCurrency();
        } catch (NumberFormatException e) {
            System.out.println("Invalid option. Please enter a number from the list.");
            return choseCurrency();
        }


        if (option == null || option < 1 || option > currencies.size()) {
            System.out.println("Invalid option");
            return choseCurrency();
        }

        return (Currency) currencies.values().toArray()[option - 1];
    }

    /**
     * CLI menu for choosing a bank.
     * @return The chosen bank
     */
    public Bank choseBank() {
        System.out.println("Choose a bank:");
        int i = 1;
        for (String bank : banks.keySet()) {
            System.out.println(i + ". " + bank);
            i++;
        }

        Integer option;
        try {
            option = AppUtils.getIntInput(scanner, "Enter an option: ");
        } catch (NoSuchElementException e) {
            System.out.println("No option was entered. Please enter a number from the list.");
            return choseBank();
        } catch (NumberFormatException e) {
            System.out.println("Invalid option. Please enter a number from the list.");
            return choseBank();
        }

        if (option == null || option < 1 || option > banks.size()) {
            System.out.println("Invalid option");
            return choseBank();
        }

        return (Bank) banks.values().toArray()[option - 1];
    }
}
