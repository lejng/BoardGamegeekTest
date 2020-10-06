package utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Storage which save data and used for pass data between steps, will clear after each scenario.
 */
public final class Context {
    private static Context instance;
    private Map<String, Object> storage;

    private Context() {
        storage = new HashMap<>();
    }

    public static Context getInstance() {
        if (instance == null) {
            instance = new Context();
        }
        return instance;
    }

    public void add(final String key, final Object value) {
        storage.put(key, value);
    }

    public <T> T get(final String key) {
        return (T)storage.get(key);
    }

    public void delete(final String key) {
        storage.remove(key);
    }

    public void clear() {
        storage.clear();
    }
}
