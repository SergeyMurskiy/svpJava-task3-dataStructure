package spbu.murskiy;

import java.util.ArrayList;

/**
 * Created by Sergey Murskiy on 15.10.2018.
 */
public class HashTable<K, V> {

    private final int minCapacity = 10;
    private int capacity;
    private Entry<K, V>[] table;
    private int size;

    //Инициализация по умолчанию
    public HashTable() {
        capacity = minCapacity;
        table = new Entry[10];
    }

    //Инициализация с заданием размера
    public HashTable(int capacity) {
        if (capacity < minCapacity) {
            capacity = minCapacity;
            table = new Entry[capacity];
        } else {
            this.capacity = capacity;
            table = new Entry[capacity];
        }
    }

    //Добавление элемента
    public void put(K key, V value) {
        int hash = key.hashCode();
        int index = hash % capacity;
        Entry<K, V> newEntry = table[index];
        if (newEntry == null) {
            newEntry = new Entry<K, V>(hash, key, value);
            table[index] = newEntry;
        } else {
            int keyIndex = newEntry.indexOfKey(key);
           /* if (keyIndex != -1 && hash) {
               newEntry.setValue(keyIndex, value);
            } else {
                newEntry.addElement(key, value);
            }*/
        }
        size++;
    }
    public int size() {
        return size;
    }
    public V get(K key) {
        int index = key.hashCode() % capacity;
        Entry<K, V> entry = table[index];
        if (entry == null) {
            return null;
        } else {
            int indexOfValue = entry.indexOfKey(key);
            if (indexOfValue == -1) {
                return null;
            } else {
                return entry.values.get(indexOfValue);
            }
        }
    }

    public V remove(K key) {
        int index = key.hashCode() % capacity;
        Entry<K, V> entry = table[index];
        if (entry == null) {
            return null;
        } else {
            int indexOfValue = entry.indexOfKey(key);
            if (indexOfValue == -1) {
                return null;
            } else {
                size--;
                return entry.remove(index);
            }
        }
    }

    private class Entry<K, V> {
        protected int hash;
        protected ArrayList<K> keys;
        protected ArrayList<V> values;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            keys = new ArrayList<K>();
            values = new ArrayList<V>();
            addElement(key, value);
        }

        public void addElement(K key, V value) {
            keys.add(key);
            values.add(value);
        }

        public int indexOfKey(K key) {
            return keys.indexOf(key);
        }

        public void setValue (int index, V value) {
            values.set(index, value);
        }

        public V remove(int index) {
            keys.remove(index);
            return values.remove(index);
        }
    }
}
