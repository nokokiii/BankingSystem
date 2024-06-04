package BankingSystem.currency;

public class Currency {
    private final String name;
    private final double exchangeRate;

    public Currency(String name, double exchangeRate) {
        validateExchangeRate(exchangeRate);
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    /**
     * Validate the exchange rate
     * @param value The exchange rate to validate
     */
    protected void validateExchangeRate(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Exchange rate cannot be negative");
        }
    }

    // Getters

    /**
     * Get the amount after converting it to this currency
     * @param amount The amount to convert
     * @return The amount after converting it to this currency
     */
    public double getConvectedAmount(double amount) {
        return amount * this.exchangeRate;
    }

    /**
     * Get the exchange rate
     * @return The exchange rate
     */
    public double getExchangeRate() {
        return this.exchangeRate;
    }

    @Override
    public String toString() {
        return this.name + " " + this.exchangeRate;
    }
}
