package src.main.currency;

public class Currency {
    private final String name;
    private double exchangeRate;

    public Currency(String name, double exchangeRate) {
        validateExchangeRate(exchangeRate);
        this.name = name;
        this.exchangeRate = exchangeRate;
    }

    protected void validateExchangeRate(double value) {
        if (value < 0) {
            throw new IllegalArgumentException("Exchange rate cannot be negative");
        }
    }

    // Setters
    public void setExchangeRate(double exchangeRate) {
        validateExchangeRate(exchangeRate);
        this.exchangeRate = exchangeRate;
    }

    // Getters
    public double getConvectedAmount(double amount) {
        return amount * this.exchangeRate;
    }

    public double getExchangeRate() {
        return this.exchangeRate;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
