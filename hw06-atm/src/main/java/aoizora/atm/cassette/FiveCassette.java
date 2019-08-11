package aoizora.atm.cassette;

import aoizora.atm.Banknote;
import aoizora.atm.types.Cassette;

import java.util.List;

public class FiveCassette implements Cassette {
    @Override
    public void insert(Banknote banknote) {

    }

    @Override
    public List<Banknote> withdraw(int count) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
