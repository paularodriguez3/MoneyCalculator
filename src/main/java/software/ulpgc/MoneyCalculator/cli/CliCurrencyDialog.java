package software.ulpgc.MoneyCalculator.cli;

import software.ulpgc.MoneyCalculator.CurrencyDialog;
import software.ulpgc.MoneyCalculator.model.Currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CliCurrencyDialog implements CurrencyDialog {
    private List<Currency> currencies;

    @Override
    public CurrencyDialog define(List<Currency> currencies) {
        this.currencies = new ArrayList<>(Objects.requireNonNull(currencies, "Las monedas no deben ser nulas"));
        System.out.println("Monedas inicializadas: " + this.currencies);
        return this;
    }

    @Override
    public Currency get() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Introduce una divisa: ");
            String code = scanner.next();
            Currency foundCurrency = findCurrency(code);
            System.out.println("Moneda encontrada: " + foundCurrency);
            if (foundCurrency != null) {
                return foundCurrency;
            }
            System.out.println(code + " no encontrado");
        }
    }

    private Currency findCurrency(String code) {
        return currencies.stream()
                .filter(c -> c.code().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}