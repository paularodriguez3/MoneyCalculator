package software.ulpgc.MoneyCalculator;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CurrencyLoader loader = new TsvCurrencyLoader(new File("currencies.tsv"));
        List<Currency> currencies = loader.load();
        for (Currency currency : currencies) {
            System.out.println(currency);
        }
    }
}
