package spbu.murskiy;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sergey Murskiy on 15.10.2018.
 */
public class HashMap<K, V> implements Map<K, V> {
    private HashTable hashTable;

    public HashMap() {
        hashTable = new HashTable();
    }

    public HashMap(int capacity) {
        hashTable = new HashTable(capacity);
    }

    public int size() {
        return hashTable.size();
    }

    public boolean isEmpty() {
        return hashTable.size() == 0;
    }

    public boolean containsKey(Object key) {
        return hashTable.containsKey(key);
    }

    public V get(Object key) {
        return (V) hashTable.get(key);
    }

    public V put(K key, V value) {
        return (V) hashTable.put(key, value);
    }

    public V remove(Object key) {
        return (V) hashTable.remove(key);
    }


    //Unsupported operations
    public boolean containsValue(Object value) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public Set<K> keySet() {
        throw new UnsupportedOperationException();
    }

    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }
}
