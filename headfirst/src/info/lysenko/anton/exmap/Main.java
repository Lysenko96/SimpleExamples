package info.lysenko.anton.exmap;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Long, String> map = new HashMap<>();
        Map<Long, String> map2 = new HashMap<>();
        Map<Long, String> map3 = new HashMap<>();
        Map<Long, String> map4 = new HashMap<>();
        map3.put(10L, "null");
        map3.put(20L, null);
        map4.put(10L, "null");
        map4.put(20L, null);
        map.put(10L, null);
        map.put(20L, "20");
        map.put(30L, "30");
        map.put(40L, "40");
        //System.out.println(map2);
        // put in new map value where key != null
        map.keySet().stream().filter(key -> map.get(key) != null).forEach(key -> map2.put(key, String.valueOf(Long.parseLong(map.get(key)))));
        //System.out.println(map2);
        map3.put(10L, "str");
        map3.put(null, "str");
        map4.replace(10L, "trs");
        map4.replace(null, "trs");
        // replace in map don't put null key in map, only change previous value
        System.out.println(map3);
        System.out.println(map4);
    }
}
