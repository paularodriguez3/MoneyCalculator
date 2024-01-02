package software.ulpgc.MoneyCalculator.swing;

import software.ulpgc.MoneyCalculator.MoneyDisplay;
import software.ulpgc.MoneyCalculator.model.Money;

import javax.swing.*;

public class SwingMoneyDisplay extends JLabel implements MoneyDisplay {
    @Override
    public void show(Money money) {
        String displayText = String.format("Resultado: %d %s", money.amount(), money.currency().code());
        this.setText(displayText);
    }
}
