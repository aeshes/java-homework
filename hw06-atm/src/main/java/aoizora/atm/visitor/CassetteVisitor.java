package aoizora.atm.visitor;

import aoizora.atm.cassette.FiveCassette;
import aoizora.atm.cassette.OneCassette;
import aoizora.atm.cassette.TenCassette;

public interface CassetteVisitor {
    long visit(OneCassette cassette);
    long visit(FiveCassette cassette);
    long visit(TenCassette cassette);
}
