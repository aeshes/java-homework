package aoizora.atm.cassette;

import aoizora.atm.Banknote;
import aoizora.atm.types.Cassette;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OneCassetteTest {

    private Cassette cassette;

    @BeforeEach
    public void before() {
        cassette = new OneCassette();
        for (int i = 0; i < 100; i++) {
            cassette.insert(Banknote.ONE);
        }
    }

    @Test
    public void count() {
        assertEquals(100, cassette.getCount());
    }

    @Test
    public void withdraw() {
        List<Banknote> result = cassette.withdraw(30);
        assertEquals(30, result.size());
        assertEquals(70, cassette.getCount());
    }
}