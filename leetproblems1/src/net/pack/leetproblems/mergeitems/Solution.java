package net.pack.leetproblems.mergeitems;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(new Solution().mergeSimilarItems(new int[][]{{1, 1}, {3, 8}}, new int[][]{{3, 1}, {4, 5}, {1, 5}}));
        System.out.println(new Solution().mergeSimilarItems(new int[][]{{5, 1}, {4, 2}, {3, 3}, {2, 4}, {1, 5}}, new int[][]{{7, 1}, {6, 2}, {5, 3}, {4, 4}}));
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = populateMap(items1);
        Map<Integer, Integer> map2 = populateMap(items2);
        List<Integer> keys = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair2 : map2.entrySet()) {
            if (!map.containsKey(pair2.getKey())) {
                map.put(pair2.getKey(), pair2.getValue());
                keys.add(pair2.getKey());
            }
        }
        map2.keySet().removeIf(keys::contains);
//        System.out.println(map);
//        System.out.println(map2);
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            for (Map.Entry<Integer, Integer> pair2 : map2.entrySet()) {
                if (pair.getKey().equals(pair2.getKey())) {
                    map.merge(pair.getKey(), pair2.getValue(), Integer::sum);
                }
            }
        }
        //System.out.println(map);
        Map<Integer, Integer> resultMap = map.entrySet().stream().sorted(Map.Entry.comparingByKey()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : resultMap.entrySet()) {
            result.add(Arrays.asList(pair.getKey(), pair.getValue()));
        }
        return result;
    }

    private Map<Integer, Integer> populateMap(int[][] items) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            for (int j = 0; j < items[i].length; j++) {
                //System.out.println(items[i][j]);
                numbers.add(items[i][j]);
            }
        }
        for (int i = 0; i < numbers.size() - 1; i += 2) {
            map.put(numbers.get(i), numbers.get(i + 1));
        }
        return map;
    }
}