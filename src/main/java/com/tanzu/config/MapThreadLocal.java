package com.tanzu.config;

import java.util.HashMap;
import java.util.Map;

public class MapThreadLocal<T> extends ThreadLocal<Map<String, T>>{
    @Override
    protected Map<String, T> initialValue() {
        return new HashMap<>();
    }

    public void removeValue(String key) {
        Map<String, T> map = get();
        if (map != null) {
            map.remove(key);
        }
    }
}
