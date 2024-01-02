package software.ulpgc.MoneyCalculator.control;

import software.ulpgc.MoneyCalculator.CurrencyDialog;
import software.ulpgc.MoneyCalculator.ExchangeRateLoader;
import software.ulpgc.MoneyCalculator.MoneyDialog;
import software.ulpgc.MoneyCalculator.MoneyDisplay;
import software.ulpgc.MoneyCalculator.model.Currency;
import software.ulpgc.MoneyCalculator.model.ExchangeRate;
import software.ulpgc.MoneyCalculator.model.Money;

import java.util.Objects;

public class ExchangeMoneyCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader exchangeRateLoader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeMoneyCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog,
                                ExchangeRateLoader exchangeRateLoader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.exchangeRateLoader = exchangeRateLoader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        try {
            Money money = moneyDialog.get();
            Currency currency = currencyDialog.get();
            Objects.requireNonNull(currency, "La moneda no puede ser nula");
            ExchangeRate exchangeRate = exchangeRateLoader.load(money.currency(), currency);
            Objects.requireNonNull(exchangeRate, "La tasa de cambio no puede ser nula");
            Money result = new Money((long) (money.amount() * exchangeRate.rate()), currency);
            moneyDisplay.show(result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}