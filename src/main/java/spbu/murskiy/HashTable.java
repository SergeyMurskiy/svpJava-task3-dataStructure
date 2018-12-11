package spbu.murskiy;

import java.util.ArrayList;

/**
 * Created by Sergey Murskiy on 15.10.2018.
 */
public class HashTable<K, V> {

    private final int minCapacity = 10;
    private int capacity;
    private ArrayList<Entry<K, V>>[] table;
    private int size;

    public HashTable() {
        capacity = minCapacity;
        table = new ArrayList[10];
        size = 0;
    }

    public HashTable(int capacity) {
        if (capacity < minCapacity) {
            capacity = minCapacity;
            table = new ArrayList[capacity];
        } else {
            this.capacity = capacity;
            table = new ArrayList[capacity];
        }
        size = 0;
    }

    public V put(K key, V value) {
        int hash = hash(key);
        int index = hash % capacity;
        Entry<K, V> newEntry = new Entry<K, V>(hash, key, value);
        if (table[index] == null) {
            table[index] = new ArrayList<Entry<K, V>>();
        }
        ArrayList<Entry<K, V>> entries = table[index];
        for (int i = 0; i < entries.size(); i++) {
            if (hash == entries.get(i).hash && key.equals(entries.get(i).key)) {
                V oldValue = entries.get(i).value;
                entries.set(i, newEntry);
                return oldValue;
            }
        }
        entries.add(newEntry);
        size++;
        return null;
    }

    public V get(K key) {
        int hash = hash(key);
        int index = hash % capacity;
        ArrayList<Entry<K, V>> entries = table[index];
        if (entries != null) {
            for (int i = 0; i < entries.size(); i++) {
                if (hash == entries.get(i).hash && key.equals(entries.get(i).key)) {
                    return entries.get(i).value;
                }
            }
        }
        return null;
    }

    public V remove(K key) {
        int hash = hash(key);
        int index = hash % capacity;
        ArrayList<Entry<K, V>> entries = table[index];
        if (entries != null) {
            for (int i = 0; i < entries.size(); i++) {
                if (hash == entries.get(i).hash && key.equals(entries.get(i).key)) {
                    V result = entries.get(i).value;
                    entries.remove(i);
                    size--;
                    return result;
                }
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int hash = hash(key);
        int index = hash % capacity;
        ArrayList<Entry<K, V>> entries = table[index];
        if (entries != null) {
            for (int i = 0; i < entries.size(); i++) {
                if (hash == entries.get(i).hash && key.equals(entries.get(i).key)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    public int hash(K key) {
        int hash;
        if (key == null) {
            hash = 0;
        } else {
            hash = key.hashCode();
        }
        return hash;
    }

    private class Entry<K, V> {
        private int hash;
        private K key;
        private V value;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}
