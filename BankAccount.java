import java.util.concurrent.ThreadLocalRandom;

public abstract class BankAccount {
    private final String accountNumber;
    public double balance;

    public BankAccount(double balance) {
        this.accountNumber = String.valueOf(ThreadLocalRandom.current().nextInt(100000, 1000000));
        this.balance = balance;
    }

    // Deposit methods
    protected void validateDeposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
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
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        } else if (amount > this.balance) {
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
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        } else if (amount > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }

    protected void performTransfer(BankAccount account, double amount) {
        this.balance -= amount;
        account.deposit(amount);
    }

    public void transfer(BankAccount account, double amount) {
        validateTransfer(account, amount);
        performTransfer(account, amount);
    }

    @Override
    public String toString() {
        return accountNumber;
    }
}
