package aoizora.atm;

import java.util.Objects;

public class Banknote {

    private final int value;

    public Banknote(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Banknote one() {
        return new Banknote(1);
    }

    public static Banknote five() {
        return new Banknote(5);
    }

    public static Banknote ten() {
        return new Banknote(10);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banknote banknote = (Banknote) o;
        return value == banknote.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
