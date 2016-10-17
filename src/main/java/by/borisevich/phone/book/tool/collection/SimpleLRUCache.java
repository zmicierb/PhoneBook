package by.borisevich.phone.book.tool.collection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by dima on 10/3/16.
 */
public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public SimpleLRUCache(int capacity) {
        super(capacity + 1, 1.1f, true);
        this.capacity = capacity;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > capacity;
    }
}