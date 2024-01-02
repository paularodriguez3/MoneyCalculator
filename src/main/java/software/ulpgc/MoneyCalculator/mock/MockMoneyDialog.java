package software.ulpgc.MoneyCalculator.mock;

import software.ulpgc.MoneyCalculator.MoneyDialog;
import software.ulpgc.MoneyCalculator.model.Currency;
import software.ulpgc.MoneyCalculator.model.Money;

import java.util.List;

public class MockMoneyDialog implements MoneyDialog {
    private List<Currency> currencies;

    @Override
    public Money get() {
        return new Money(350, currencies.get(0));
    }

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        this.currencies = currencies;
        return this;
    }

}