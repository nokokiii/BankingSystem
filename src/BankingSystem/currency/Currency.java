package BankingSystem.currency;

public class Currency {
    private final String name;
    private final double exchangeRate;

    public Currency(String name, double exchangeRate) {
        this.name = name;
        this.exchangeRate = exchangeRate;
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
