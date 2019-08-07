package aoizora.atm;

import java.util.ArrayList;
import java.util.List;

public class Atm {

    private long money;

    public Atm() {
        this(0);
    }

    public Atm(long money) {
        this.money = money;
    }

    public void oneSlot(Banknote banknote) {
        if (banknote.getValue() != 1) {
            throw new RuntimeException("Incorrect value: " + banknote.getValue());
        }
        accept(banknote);
    }

    public void fiveSlot(Banknote banknote) {
        if (banknote.getValue() != 5) {
            throw new RuntimeException("Incorrect value: " + banknote.getValue());
        }
        accept(banknote);
    }

    public void tenSlot(Banknote banknote) {
        if (banknote.getValue() != 10) {
            throw new RuntimeException("Incorrect value: " + banknote.getValue());
        }
        accept(banknote);
    }

    private void accept(Banknote banknote) {
        money += banknote.getValue();
    }

    public List<Banknote> withdraw(int value) {

        checkBalance(value);

        List<Banknote> result = new ArrayList<>();
        while (money >= 10 && value >= 10) {
            result.add(Banknote.ten());
            money -= 10;
            value -= 10;
        }

        while (money >= 5 && value >= 5) {
            result.add(Banknote.five());
            money -= 5;
            value -= 5;
        }

        while (money >= 1 && value >= 1) {
            result.add(Banknote.one());
            money -= 1;
            value -= 1;
        }

        return result;
    }

    private void checkBalance(int value) {
        if (money < value)
            throw new RuntimeException("Not enough money");
    }

    public long getCacheBalance() {
        return money;
    }
}
