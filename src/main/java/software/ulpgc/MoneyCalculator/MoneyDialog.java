package software.ulpgc.MoneyCalculator;

import software.ulpgc.MoneyCalculator.model.Currency;
import software.ulpgc.MoneyCalculator.model.Money;

import java.util.List;

public interface MoneyDialog {
    Money get();
    default MoneyDialog define(List<Currency> currencies) {
        return this;
    }
}
