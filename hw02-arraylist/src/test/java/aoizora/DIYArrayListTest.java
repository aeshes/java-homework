package aoizora;

import static org.junit.jupiter.api.Assertions.*;

class DIYArrayListTest {

    @org.junit.jupiter.api.Test
    void get() {
        DIYArrayList arrayList = new DIYArrayList();
        arrayList.add("a");
        assertEquals("a", arrayList.get(0));
    }

    @org.junit.jupiter.api.Test
    void size() {
        DIYArrayList<String> arrayList = new DIYArrayList<>();

        arrayList.add("a");
        assertEquals(1, arrayList.size());

        arrayList.add("b");
        assertEquals(2, arrayList.size());
    }
}