package org.example.multithreading.concurrentmap;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TestConcurrentMap {

    public static void main(String[] args) {
        ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "Vasya");
        map.put(2, "Petya");
        map.put(3, "Katya");
        map.put(4, "Masha");
        map.put(5, "Anton");
        map.put(6, "Yulia");
        new Thread(()-> {
            Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    Map.Entry<Integer, String> pair = it.next();
                    System.out.println(pair.getKey() + ": " + pair.getValue());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        new Thread(()-> {
            try {
                Thread.sleep(300);
//                map.put(null, "null"); // error
                map.put(8, "Dasha");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }
}
