package net.pack.leetcodestyle.convertinto2darr;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findMatrix(new int[]{1,3,4,1,2,3,1}));
    }

    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<List<Integer>> result = new ArrayList<>();
        long maxValue = map.values().stream().max(Comparator.naturalOrder()).orElse(0L);
        for(int i = 0; i < maxValue; i++) {
            List<Integer> subList = new ArrayList<>();
            for (Map.Entry<Integer, Long> pair : map.entrySet()) {
                if (pair.getValue() > 0) {
                    subList.add(pair.getKey());
                    pair.setValue(pair.getValue() - 1);
                }
            }
            result.add(subList);
        }
        return result;
    }
}
