package software.ulpgc.MoneyCalculator;

import software.ulpgc.MoneyCalculator.model.Currency;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class TsvCurrencyLoader implements CurrencyLoader {
    private final File file;
    public TsvCurrencyLoader(File file) {
        this.file = file;
    }
    @Override
    public List<Currency> load() throws RuntimeException {
        try {
            return load(new FileReader(file));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private List<Currency> load(FileReader reader) throws IOException {
        return load(new BufferedReader(reader));
    }
    private List<Currency> load(BufferedReader reader) throws IOException {
        List<Currency> result = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            result.add(toCurrency(line));
        }
        return result;
    }
    private Currency toCurrency(String line) {
        return toCurrency(line.split("\t"));
    }

    private Currency toCurrency(String[] fields) {
        return new Currency(fields[0], fields[1]);
    }

}