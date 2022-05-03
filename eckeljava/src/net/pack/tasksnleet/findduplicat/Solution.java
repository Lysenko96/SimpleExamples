package net.pack.tasksnleet.findduplicat;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : nums) {
            list.add(i);
        }
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(map);
        return map.entrySet().stream().filter(p -> p.getValue() >= 2).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
