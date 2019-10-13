package aoizora.cache;

import aoizora.base.CacheHw;
import aoizora.base.HwListener;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class CacheImpl<K, V> implements CacheHw<K, V> {

    private Map<K, V> cache = new WeakHashMap<>();

    private List<SoftReference<HwListener<K, V>>> listeners = new ArrayList<>();


    public void put(K key, V value) {
        for (SoftReference<HwListener<K, V>> listener : listeners) {
            HwListener<K, V> l = listener.get();
            if (l != null) {
                l.notify(key, value, "put");
            }
        }

        cache.put(key, value);
    }

    public void remove(K key) {
        for (SoftReference<HwListener<K, V>> listener : listeners) {
            HwListener<K, V> l = listener.get();
            if (l != null) {
                l.notify(key, cache.get(key), "remove");
            }
        }

        cache.remove(key);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public void addListener(HwListener listener) {
        listeners.add(new SoftReference<>(listener));
    }

    public void removeListener(HwListener listener) {
        listeners.remove(listener);
    }
}
