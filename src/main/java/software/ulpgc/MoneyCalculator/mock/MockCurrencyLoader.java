package software.ulpgc.MoneyCalculator.mock;

import software.ulpgc.MoneyCalculator.CurrencyLoader;
import software.ulpgc.MoneyCalculator.model.Currency;

import java.util.List;

public class MockCurrencyLoader implements CurrencyLoader {

    @Override
    public List<Currency> load() {
        return List.of(
                new Currency("EUR", "Euro"),
                new Currency("GBP", "Libra"),
                new Currency("USD", "Dólar")
        );
    }

}