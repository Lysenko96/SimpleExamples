package net.pack.leetcodestyle.majorityelem;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[]{3, 3, 3, 2, 2, 2, 2, 2, 1, 1, 1}));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map.Entry<Integer, Long> entry = map.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(null);
        return entry == null ? 0 : entry.getKey();
    }
}
