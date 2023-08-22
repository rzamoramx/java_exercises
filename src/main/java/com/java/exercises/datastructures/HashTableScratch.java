package com.java.exercises.datastructures;

import java.util.ArrayList;
import java.util.List;

public class HashTableScratch<K, V> {
    private int size;
    private List<List<Entry<K, V>>> table;

    public HashTableScratch(int size) {
        this.size = size;
        this.table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(new ArrayList<>());
        }
    }

    private int hashFunction(K key) {
        return key.hashCode() % size;
    }

    public void insert(K key, V value) {
        int index = hashFunction(key);
        table.get(index).add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = hashFunction(key);
        List<Entry<K, V>> entries = table.get(index);
        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    private static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
