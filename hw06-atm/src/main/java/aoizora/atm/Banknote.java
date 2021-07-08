package aoizora.atm;

public enum Banknote {
    ONE(1),
    FIVE(5),
    TEN(10);

    Banknote(int nominal) {
        this.nominal = nominal;
    }

    public int getNominal() {
        return nominal;
    }

    private int nominal;
}
