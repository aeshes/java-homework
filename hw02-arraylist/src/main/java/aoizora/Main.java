package aoizora;

public class Main {

    public static void main(String[] args) {
        print("key", 13);
    }

    private static <K, V> void print(K key, V value) {
        System.out.println("key = " + key + ", value = " + value);
    }
}
