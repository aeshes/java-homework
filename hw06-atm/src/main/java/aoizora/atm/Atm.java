package aoizora.atm;

import aoizora.atm.cassette.FiveCassette;
import aoizora.atm.cassette.OneCassette;
import aoizora.atm.cassette.TenCassette;
import aoizora.atm.types.Cassette;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Atm {

    private Map<Integer, Cassette> cassettes = Stream.of(new Object[][] {
            {Banknote.ONE.getNominal(), new OneCassette(1000)},
            {Banknote.FIVE.getNominal(), new FiveCassette(1000)},
            {Banknote.TEN.getNominal(), new TenCassette(1000)}
    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (Cassette) data[1]));

    public void oneSlot(Banknote banknote) {
        cassettes.get(banknote.getNominal()).insert(banknote);
    }

    public void fiveSlot(Banknote banknote) {
        cassettes.get(banknote.getNominal()).insert(banknote);
    }

    public void tenSlot(Banknote banknote) {
        cassettes.get(banknote.getNominal()).insert(banknote);
    }

    public long totalBalance() {
        return cassettes.entrySet().stream()
                .map(entry -> entry.getKey() * entry.getValue().getBanknoteCount())
                .reduce(0, Integer::sum);
    }
}
