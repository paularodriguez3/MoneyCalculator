package software.ulpgc.MoneyCalculator;

import software.ulpgc.MoneyCalculator.model.Currency;
import java.util.List;

public interface CurrencyLoader {
        List<Currency> load();
}
