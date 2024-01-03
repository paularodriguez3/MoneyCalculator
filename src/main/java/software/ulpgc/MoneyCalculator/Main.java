package software.ulpgc.MoneyCalculator;

import software.ulpgc.MoneyCalculator.cli.CliCurrencyDialog;
import software.ulpgc.MoneyCalculator.cli.CliMoneyDialog;
import software.ulpgc.MoneyCalculator.control.ExchangeMoneyCommand;
import software.ulpgc.MoneyCalculator.mock.MockCurrencyLoader;
import software.ulpgc.MoneyCalculator.mock.MockExchangeRateLoader;
import software.ulpgc.MoneyCalculator.mock.MockMoneyDisplay;
import software.ulpgc.MoneyCalculator.model.Currency;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MockCurrencyLoader currencyLoader = new MockCurrencyLoader();
        List<Currency> currencies = currencyLoader.load();

        MoneyDialog moneyDialog = new CliMoneyDialog().define(currencies);

        CurrencyDialog currencyDialog = new CliCurrencyDialog().define(currencies);
        MoneyDisplay moneyDisplay = new MockMoneyDisplay();
        ExchangeRateLoader exchangeRateLoader = new MockExchangeRateLoader();
        ExchangeMoneyCommand exchangeMoneyCommand = new ExchangeMoneyCommand(moneyDialog, currencyDialog, exchangeRateLoader, moneyDisplay);
        exchangeMoneyCommand.execute();
    }

}