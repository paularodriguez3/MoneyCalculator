package software.ulpgc.MoneyCalculator.swing;

import software.ulpgc.MoneyCalculator.CurrencyDialog;
import software.ulpgc.MoneyCalculator.MoneyDialog;
import software.ulpgc.MoneyCalculator.MoneyDisplay;
import software.ulpgc.MoneyCalculator.control.Command;
import software.ulpgc.MoneyCalculator.control.ExchangeMoneyCommand;
import software.ulpgc.MoneyCalculator.fixerws.FixerCurrencyLoader;
import software.ulpgc.MoneyCalculator.mock.MockExchangeRateLoader;
import software.ulpgc.MoneyCalculator.model.Currency;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SwingMain extends JFrame {
    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private MoneyDisplay moneyDisplay;
    private Map<String, Command> commands = new HashMap<>();

    public static void main(String[] args) {
        SwingMain main = new SwingMain();
        List<Currency> currencies = new FixerCurrencyLoader().load();
        Command command = new ExchangeMoneyCommand(
                main.moneyDialog().define(currencies),
                main.currencyDialog().define(currencies),
                new MockExchangeRateLoader(),
                main.moneyDisplay()
        );
        main.add("Intercambio monetario", command);
        main.setVisible(true);
    }

    public void add(String name, Command command) {
        commands.put(name, command);
    }

    public SwingMain() throws HeadlessException {
        this.setTitle("Money Calculator");
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.getContentPane().setBackground(new Color(255, 240, 245));

        JLabel titleLabel = new JLabel("Money Calculator", JLabel.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
        titleLabel.setForeground(new Color(219, 112, 147));
        this.add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(255, 240, 245));

        mainPanel.add(createMoneyDialog());
        mainPanel.add(createCurrencyDialog());
        mainPanel.add(createMoneyDisplay());

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(createCalculateButton(), BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private Component createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.setPreferredSize(new Dimension(200, 40));
        button.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        button.setBackground(new Color(219, 112, 147));
        button.setForeground(Color.white);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.addActionListener(e -> commands.get("Intercambio monetario").execute());
        return button;
    }

    private Component createMoneyDisplay() {
        SwingMoneyDisplay display = new SwingMoneyDisplay();
        this.moneyDisplay = display;
        return display;
    }

    private Component createCurrencyDialog() {
        SwingCurrencyDialog dialog = new SwingCurrencyDialog();
        this.currencyDialog = dialog;
        return dialog;
    }

    private Component createMoneyDialog() {
        SwingMoneyDialog dialog = new SwingMoneyDialog();
        this.moneyDialog = dialog;
        return dialog;
    }

    private MoneyDisplay moneyDisplay() {
        return moneyDisplay;
    }

    private CurrencyDialog currencyDialog() {
        return currencyDialog;
    }

    private MoneyDialog moneyDialog() {
        return moneyDialog;
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
