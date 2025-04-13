package store;

import datastructure.ValueWrapper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class InMemoryKeyValueStore {
    private final ConcurrentHashMap<String, ValueWrapper> store = new ConcurrentHashMap<>();
    private final ScheduledExecutorService cleaner = Executors.newSingleThreadScheduledExecutor();

    public InMemoryKeyValueStore() {
        cleaner.scheduleAtFixedRate(this::evictExpiredKeys, 5, 5, TimeUnit.SECONDS);
    }

    public void put(String key, String value) {
        store.put(key, new ValueWrapper(value, -1));
    }

    public void put(String key, String value, long ttlMillis) {
        store.put(key, new ValueWrapper(value, ttlMillis));
    }

    public String get(String key) {
        ValueWrapper wrapper = store.get(key);
        if (wrapper == null || wrapper.isExpired()) {
            store.remove(key);
            return null;
        }
        return wrapper.value;
    }

    private void evictExpiredKeys() {
        for (Map.Entry<String, ValueWrapper> entry : store.entrySet()) {
            if (entry.getValue().isExpired()) {
                store.remove(entry.getKey());
            }
        }
    }

    public void shutdown() {
        cleaner.shutdown();
    }
}
