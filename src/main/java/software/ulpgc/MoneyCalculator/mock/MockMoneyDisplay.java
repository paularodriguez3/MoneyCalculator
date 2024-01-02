package software.ulpgc.MoneyCalculator.mock;

import software.ulpgc.MoneyCalculator.MoneyDisplay;
import software.ulpgc.MoneyCalculator.model.Money;

public class MockMoneyDisplay implements MoneyDisplay {

    @Override
    public void show(Money money) {
        System.out.println(money);
    }

}