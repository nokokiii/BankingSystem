package accounts;

public class checkingAccount extends BankAccount {
    protected double transferFee;
    protected double withdrawalFee;
    protected double transferLimit;
    protected double withdrawalLimit;

    public checkingAccount(double balance, double transferFee, double withdrawalFee, double withdrawalLimit, double transferLimit) {
        super(balance);
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

    // Setters
    public void setTransferFee(double transferFee) {
        validateNonNegative(transferFee, "Transfer fee cannot be negative");
        this.transferFee = transferFee;
    }

    public void setWithdrawalFee(double withdrawalFee) {
        validateNonNegative(withdrawalFee, "Withdrawal fee cannot be negative");
        this.withdrawalFee = withdrawalFee;
    }

    public void setTransferLimit(double transferLimit) {
        validateNonNegative(transferLimit, "Transfer limit cannot be negative");
        this.transferLimit = transferLimit;
    }

    public void setWithdrawalLimit(double withdrawalLimit) {
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
