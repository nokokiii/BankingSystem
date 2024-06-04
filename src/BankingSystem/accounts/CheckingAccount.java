package BankingSystem.accounts;

public class CheckingAccount extends BankAccount {
    protected double transferFee;
    protected double withdrawalFee;
    protected double transferLimit;
    protected double withdrawalLimit;

    public CheckingAccount(double balance, String pin, double transferFee, double withdrawalFee, double withdrawalLimit, double transferLimit) {
        super(balance, pin);
        setTransferFee(transferFee);
        setWithdrawalFee(withdrawalFee);
        setTransferLimit(transferLimit);
        setWithdrawalLimit(withdrawalLimit);
    }

    // Withdrawal methods
    @Override
    protected void validateWithdrawal(double amount) {
        validateNonNegative(amount, "Amount cannot be negative");
        double transferFee = amount * this.transferFee;
        if (amount + transferFee > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        } else if (amount > this.withdrawalLimit) {
            throw new IllegalArgumentException("Amount exceeds maximum withdrawal amount");
        }
    }

    @Override
    protected void performWithdrawal(double amount) {
        double transferFee = amount * this.transferFee;
        this.balance -= amount + transferFee;
    }

    // Transfer methods
    @Override
    protected void validateTransfer(BankAccount account, double amount) {
        validateBankAccount(account);
        double transferFee = amount * this.transferFee;
        if (amount + transferFee > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        } else if (amount > this.transferLimit) {
            throw new IllegalArgumentException("Amount exceeds maximum transfer amount");
        }
    }

    // Setters
    private void setTransferFee(double transferFee) {
        validateNonNegative(transferFee, "Transfer fee cannot be negative");
        this.transferFee = transferFee;
    }

    private void setWithdrawalFee(double withdrawalFee) {
        validateNonNegative(withdrawalFee, "Withdrawal fee cannot be negative");
        this.withdrawalFee = withdrawalFee;
    }

    private void setTransferLimit(double transferLimit) {
        validateNonNegative(transferLimit, "Transfer limit cannot be negative");
        this.transferLimit = transferLimit;
    }

    private void setWithdrawalLimit(double withdrawalLimit) {
        validateNonNegative(withdrawalLimit, "Withdrawal limit cannot be negative");
        this.withdrawalLimit = withdrawalLimit;
    }

    // Getters
    public double getTransferFee() {
        return this.transferFee;
    }

    public double getWithdrawalFee() {
        return this.withdrawalFee;
    }

    public double getTransferLimit() {
        return this.transferLimit;
    }

    public double getWithdrawalLimit() {
        return this.withdrawalLimit;
    }
}
