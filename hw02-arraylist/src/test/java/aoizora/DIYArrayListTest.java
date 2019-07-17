package aoizora;

import com.google.common.collect.Ordering;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DIYArrayListTest {

    @Test
    void get() {
        DIYArrayList arrayList = new DIYArrayList();
        arrayList.add("a");
        assertEquals("a", arrayList.get(0));
    }

    @Test
    void size() {
        DIYArrayList<String> arrayList = new DIYArrayList<>();

        arrayList.add("a");
        assertEquals(1, arrayList.size());

        arrayList.add("b");
        assertEquals(2, arrayList.size());
    }

    @Test
    void testAddAll() {
        DIYArrayList<Integer> arrayList = new DIYArrayList<>();
        Collections.addAll(arrayList, 1, 2, 3, 4, 5, 9, 8, 7, 6, 12, 13, 14, 15, 20, 19, 18,  17, 16);
        assertEquals(arrayList.size(), 18);
    }

    @Test
    void testCopy() {
        DIYArrayList<UUID> arrayList = new DIYArrayList<>();
        List<UUID> src = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            src.add(UUID.randomUUID());
        }
        Collections.copy(arrayList, src);
        assertEquals(src.size(), arrayList.size());
    }

    @Test
    void testSort() {
        DIYArrayList<Integer> arrayList = new DIYArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 20; ++i) {
            int n = rand.nextInt(100);
            arrayList.add(n);
        }
        Collections.sort(arrayList, Comparator.naturalOrder());
        assertTrue(Ordering.natural().isOrdered(arrayList));
    }
}