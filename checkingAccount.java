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
        double transferFee = amount * this.transferFee;
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        } else if (amount + transferFee > this.balance) {
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
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        } else if (amount + transferFee > this.balance) {
            throw new IllegalArgumentException("Insufficient funds");
        } else if (amount > this.transferLimit) {
            throw new IllegalArgumentException("Amount exceeds maximum transfer amount");
        }
    }

    @Override
    protected void performTransfer(BankAccount account, double amount) {
        double transferFee = amount * this.transferFee;
        this.balance -= amount + transferFee;
        account.deposit(amount);
    }

    // Setters
    public void setTransferFee(double transferFee) {
        if (transferFee < 0) {
            throw new IllegalArgumentException("Transfer fee cannot be negative");
        }
        this.transferFee = transferFee;
    }

    public void setWithdrawalFee(double withdrawalFee) {
        if (withdrawalFee < 0) {
            throw new IllegalArgumentException("Withdrawal fee cannot be negative");
        }
        this.withdrawalFee = withdrawalFee;
    }

    public void setTransferLimit(double transferLimit) {
        if (transferLimit < 0) {
            throw new IllegalArgumentException("Transfer limit cannot be negative");
        }
        this.transferLimit = transferLimit;
    }

    public void setWithdrawalLimit(double withdrawalLimit) {
        if (withdrawalLimit < 0) {
            throw new IllegalArgumentException("Withdrawal limit cannot be negative");
        }
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
