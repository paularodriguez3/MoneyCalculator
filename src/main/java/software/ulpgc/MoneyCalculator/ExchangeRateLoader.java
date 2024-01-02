package software.ulpgc.MoneyCalculator;

import software.ulpgc.MoneyCalculator.model.Currency;
import software.ulpgc.MoneyCalculator.model.ExchangeRate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to);
}
