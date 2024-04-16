package org.example.multithreading.concurrentnavigablemap;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class TestConcurrentNavigableMap {

    public static void main(String[] args) {
        // Creating a ConcurrentNavigableMap
        ConcurrentNavigableMap<String, Integer> map = new ConcurrentSkipListMap<>();

        // Adding elements
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);

        // Displaying the original map
        System.out.println("Original Map: " + map);

        // Tail Map (inclusive of given key)
        ConcurrentNavigableMap<String, Integer> tailMap = map.tailMap("B"); // inclusive true default
        System.out.println("Tail Map: " + tailMap);

        // Head Map (exclusive of given key)
        ConcurrentNavigableMap<String, Integer> headMap = map.headMap("B"); // // inclusive false default
        System.out.println("Head Map: " + headMap);

        // Sub Map (range fromKey inclusive, toKey exclusive)
        ConcurrentNavigableMap<String, Integer> subMap = map.subMap("A", "D");
        System.out.println("Sub Map: " + subMap);

        // Descending Map
        ConcurrentNavigableMap<String, Integer> descMap = map.descendingMap();
        System.out.println("Descending Map: " + descMap);
    }
}
