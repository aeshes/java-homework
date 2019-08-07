package aoizora.atm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AtmTest {

    private Atm atm;

    @BeforeEach
    public void before() {
        this.atm = new Atm();
        atm.tenSlot(Banknote.ten());
        atm.fiveSlot(Banknote.five());
        atm.oneSlot(Banknote.one());
    }

    @Test
    public void cacheBalance() {
        assertEquals(16L, atm.getCacheBalance());
    }

    @Test
    public void withdraw() {
        atm.withdraw(10);
        assertEquals(6L, atm.getCacheBalance());
    }

    @Test
    public void exchange() {
        List<Banknote> actual = atm.withdraw(13);
        List<Banknote> expected = Arrays.asList(Banknote.ten(), Banknote.one(), Banknote.one(), Banknote.one());
        assertEquals(expected, actual);
    }

    @Test
    public void exception() {
        assertThrows(RuntimeException.class, () -> atm.withdraw(1488));
    }
}