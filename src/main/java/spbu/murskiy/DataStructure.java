package spbu.murskiy;

import java.util.Hashtable;

/**
 * Created by Sergey Murskiy on 15.10.2018.
 */

public class DataStructure {
    public static void main(String[] args) {
        HashTable<Integer, String> newHash = new HashTable<Integer, String>(20);
        newHash.put(10, "qwerty");
        newHash.put(7, "qwerty1");
        newHash.put(10, "asdasdasd");
        System.out.println(newHash.get(10));
        System.out.println(newHash.get(7));
        System.out.println(newHash.size());
    }
}
