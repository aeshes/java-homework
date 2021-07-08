package aoizora.atm.visitor;

import aoizora.atm.Banknote;
import aoizora.atm.cassette.FiveCassette;
import aoizora.atm.cassette.OneCassette;
import aoizora.atm.cassette.TenCassette;

public class BalanceVisitor implements CassetteVisitor {
    @Override
    public long visit(OneCassette cassette) {
        if (cassette.getBanknoteType() == Banknote.ONE) {
            return cassette.getBanknoteCount();
        }
        throw new RuntimeException("Incorrect banknote type");
    }

    @Override
    public long visit(FiveCassette cassette) {
        if (cassette.getBanknoteType() == Banknote.FIVE) {
            return cassette.getBanknoteCount() * 5;
        }
        throw new RuntimeException("Incorrect banknote type");
    }

    @Override
    public long visit(TenCassette cassette) {
        if (cassette.getBanknoteType() == Banknote.TEN) {
            return cassette.getBanknoteCount() * 10;
        }
        throw new RuntimeException("Incorrect banknote type");
    }
}
