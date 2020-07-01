package MyMap;

import java.util.*;

//This map does not permit null keys or values
public class MyMap implements Map {
    private static final int NUM_BUCKETS = 16;
    private Entry[] data = new Entry[NUM_BUCKETS];
    private int size = 0;
    private HashSet keys = new HashSet();

    private int getIndex(Object o) {
        return Math.abs(o.hashCode()) % NUM_BUCKETS;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            throw new NullPointerException("Null keys are not permitted");
        }

        return keys.contains(key);
    }

    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            throw new NullPointerException("Null values are not permitted");
        }

        for (Entry row : data) {
            Entry entry = row;

            while (entry != null) {
                if (entry.getValue().equals(value)) {
                    return true;
                }

                entry = entry.next;
            }
        }

        return false;
    }

    @Override
    public Object get(Object key) {
        if (key == null) {
            throw new NullPointerException("Null keys are not permitted");
        }

        int index = getIndex(key);

        Entry entry = data[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }

            entry = entry.next;
        }

        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        if (key == null || value == null) {
            throw new NullPointerException("Null keys or values are not permitted");
        }

        int index = getIndex(key);

        Entry entry = data[index];

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                Object oldValue = entry.getValue();
                entry.setValue(value);

                return oldValue;
            }

            entry = entry.next;
        }

        data[index] = new Entry(key, value, data[index]);
        keys.add(key);
        size++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        if (key == null) {
            throw new NullPointerException("Null keys are not permitted");
        }

        int index = getIndex(key);

        Entry entry = data[index];
        Entry previousEntry = null;

        while (entry != null) {
            if (entry.getKey().equals(key)) {
                Object oldValue = entry.getValue();

                if (previousEntry == null) {
                    data[index] = entry.next;
                } else {
                    previousEntry.next = entry.next;
                }

                size--;
                keys.remove(key);

                return oldValue;
            }

            previousEntry = entry;
            entry = entry.next;
        }

        return null;
    }

    @Override
    public void putAll(Map m) {
        if (m == null) {
            throw new NullPointerException("Null map is not permitted");
        }
        if (m.containsKey(null)) {
            throw new NullPointerException("Null keys are not permitted");
        }
        if (m.containsValue(null)) {
            throw new NullPointerException("Null values are not permitted");
        }

        Set entrySet = m.entrySet();

        for (Object entry : entrySet) {
            Map.Entry e = (Map.Entry) entry;
            put(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < NUM_BUCKETS; i++) {
            data[i] = null;
        }

        keys.clear();

        size = 0;
    }

    @Override
    public Set keySet() {
        return keys;
    }

    @Override
    public Collection values() {
        ArrayList values = new ArrayList();

        for (int i = 0; i < NUM_BUCKETS; i++) {
            Entry entry = data[i];

            while (entry != null) {
                values.add(entry.getValue());

                entry = entry.next;
            }
        }

        return values;
    }

    @Override
    public Set<Entry> entrySet() {
        HashSet entrySet = new HashSet();

        for (int i = 0; i < NUM_BUCKETS; i++) {
            Entry entry = data[i];

            while (entry != null) {
                entrySet.add(entry);

                entry = entry.next;
            }
        }

        return entrySet;
    }

    private static class Entry implements Map.Entry {
        Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            Object oldValue = this.value;
            this.value = value;
            return oldValue;
        }
    }
}
