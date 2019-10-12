package aoizora.cache;

import aoizora.base.CacheHw;
import aoizora.base.HwListener;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class CacheImpl<K, V> implements CacheHw<K, V> {

    private Map<K, V> data = new WeakHashMap<>();

    private List<SoftReference<HwListener>> listeners = new ArrayList<>();


    public void put(K key, V value) {

    }

    public void remove(K key) {

    }

    public V get(K key) {
        return null;
    }

    public void addListener(HwListener listener) {

    }

    public void removeListener(HwListener listener) {

    }
}
