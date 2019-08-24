package aoizora.atm.types;

import aoizora.atm.Banknote;

import java.util.List;

public interface Cassette {
    void insert(Banknote banknote);
    List<Banknote> withdraw(int count);
    int getBanknoteCount();
    Banknote getBanknoteType();
}
