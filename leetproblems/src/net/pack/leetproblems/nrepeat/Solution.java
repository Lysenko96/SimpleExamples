package net.pack.leetproblems.nrepeat;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedNTimes(new int[]{1, 2, 3, 3}));
    }

    public int repeatedNTimes(int[] nums) {
        Map<Integer, Long> map;
        List<Integer> list = new ArrayList<>();
        for (Integer i : nums) {
            list.add(i);
        }
        map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Integer> values = new ArrayList<>();
        int result = 0;
        for (Map.Entry<Integer, Long> pair : map.entrySet()) {
            values.add(pair.getValue().intValue());
            if (pair.getValue().intValue() == Collections.max(values)) {
                result = pair.getKey();
            }
        }
        return result;
    }
}