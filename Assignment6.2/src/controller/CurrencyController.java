package controller;

import model.Currency;
import java.util.ArrayList;
import java.util.List;

public class CurrencyController {
    private List<Currency> currencies;

    public CurrencyController() {
        currencies = new ArrayList<>();

        currencies.add(new Currency("USD", "US Dollar", 1.00));
        currencies.add(new Currency("EUR", "Euro", 1.08));
        currencies.add(new Currency("GBP", "British Pound", 1.27));
        currencies.add(new Currency("JPY", "Japanese Yen", 0.0065));
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public double convert(double amount, Currency from, Currency to) {
        if (from == null || to == null)
            throw new IllegalArgumentException("Currencies must not be null");

        if (amount <= 0.0)
            return 0.0;

        // Convert from → USD
        double amountInUSD = amount * from.getRateToUSD();

        // Convert USD → to
        return amountInUSD / to.getRateToUSD();
    }
}
