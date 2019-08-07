package aoizora;

import aoizora.atm.Atm;
import aoizora.atm.Banknote;

public class Main {

    public static void main(String[] args) {
        Atm atm = new Atm();

        atm.oneSlot(Banknote.one());
        atm.fiveSlot(Banknote.five());
        atm.tenSlot(Banknote.ten());

        atm.withdraw(13)
                .forEach(banknote -> System.out.println(banknote.getValue() + " banknotes"));
    }
}
