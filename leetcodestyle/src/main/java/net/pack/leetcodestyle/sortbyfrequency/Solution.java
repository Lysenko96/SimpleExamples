package net.pack.leetcodestyle.sortbyfrequency;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.frequencySort("tree");
        solution.frequencySort("aaaccc");
        solution.frequencySort("Aabb");
    }

    public String frequencySort(String s) {
        Map<String, Long> result = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Set<Map.Entry<String, Long>> entry = result.entrySet();
        List<Map.Entry<String, Long>> sorted = entry.stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Long> entry1 : sorted) {
            while (entry1.getValue() > 0){
                sb.append(entry1.getKey());
                entry1.setValue(entry1.getValue()-1);
            }
        }
        return sb.toString();
    }
}
