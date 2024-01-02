package software.ulpgc.MoneyCalculator.mock;

import software.ulpgc.MoneyCalculator.ExchangeRateLoader;
import software.ulpgc.MoneyCalculator.model.Currency;
import software.ulpgc.MoneyCalculator.model.ExchangeRate;

import java.time.LocalDate;

public class MockExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return new ExchangeRate(from, to, LocalDate.now(), 1.2312);
    }

}