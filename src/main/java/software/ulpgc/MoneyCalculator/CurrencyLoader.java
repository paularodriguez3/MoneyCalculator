package software.ulpgc.MoneyCalculator;

import java.util.List;

public interface CurrencyLoader {
        List<Currency> load() throws RuntimeException;
}
