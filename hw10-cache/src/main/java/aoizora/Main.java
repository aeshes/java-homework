package aoizora;

import aoizora.base.CacheHw;
import aoizora.base.HwListener;
import aoizora.cache.CacheImpl;

public class Main {

    public static void main(String[] args) {
        CacheHw<Integer, String> cache = new CacheImpl<>();

        HwListener<Integer, String> listener = (key, value, action) ->
                System.out.println("Key: " + key + ", value: " + value + ", action: " + action);

        cache.addListener(listener);

        cache.put(1, "Hello");
    }
}
