package aoizora.atm.cassette;

import aoizora.atm.Banknote;
import aoizora.atm.types.Cassette;

import java.util.ArrayList;
import java.util.List;

public class OneCassette implements Cassette {

    private int count;

    @Override
    public void insert(Banknote banknote) {
        if (!banknote.equals(Banknote.ONE))
            throw new RuntimeException("Invalid banknote value: " + banknote);
        this.count++;
    }

    @Override
    public int getBanknoteCount() {
        return count;
    }

    @Override
    public Banknote getBanknoteType() {
        return Banknote.ONE;
    }

    public List<Banknote> withdraw(int count) {

        if (this.count < count)
            throw new RuntimeException("Not enough banknotes");

        List<Banknote> result = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            result.add(Banknote.ONE);
            this.count--;
        }
        return result;
    }
}
