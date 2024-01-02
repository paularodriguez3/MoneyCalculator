package software.ulpgc.MoneyCalculator.cli;

import software.ulpgc.MoneyCalculator.CurrencyDialog;
import software.ulpgc.MoneyCalculator.MoneyDialog;
import software.ulpgc.MoneyCalculator.model.Currency;
import software.ulpgc.MoneyCalculator.model.Money;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CliMoneyDialog implements MoneyDialog {
    private CurrencyDialog currencyDialog;

    @Override
    public Money get() {
        return new Money(amount(), currency());
    }

    private Currency currency() {
        Currency currency = currencyDialog.get();
        System.out.println("Currency from CliMoneyDialog: " + currency);
        return currency;
    }

    @Override
    public MoneyDialog define(List<Currency> currencies) {
        this.currencyDialog = new CliCurrencyDialog().define(currencies);
        return this;
    }

    private long amount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce una cantidad: ");
        return scanner.nextLong();
    }
}