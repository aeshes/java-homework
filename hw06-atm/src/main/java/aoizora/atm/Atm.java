package aoizora.atm;

import aoizora.atm.cassette.FiveCassette;
import aoizora.atm.cassette.OneCassette;
import aoizora.atm.cassette.TenCassette;
import aoizora.atm.types.Cassette;
import aoizora.atm.visitor.BalanceVisitor;
import aoizora.atm.visitor.CassetteVisitor;

public class Atm {

    private Cassette ones = new OneCassette(1000);
    private Cassette fives = new FiveCassette(1000);
    private Cassette tens = new TenCassette(1000);

    public void oneSlot(Banknote banknote) {
        ones.insert(banknote);
    }

    public void fiveSlot(Banknote banknote) {
        fives.insert(banknote);
    }

    public void tenSlot(Banknote banknote) {
        tens.insert(banknote);
    }

    public long totalBalance() {
        CassetteVisitor visitor = new BalanceVisitor();
        return ones.accept(visitor)
                + fives.accept(visitor)
                + tens.accept(visitor);
    }
}
