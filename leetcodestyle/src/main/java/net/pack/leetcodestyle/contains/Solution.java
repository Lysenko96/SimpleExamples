package net.pack.leetcodestyle.contains;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsDuplicate(new int[]{1,4,2,3}));
    }

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Long> map = Arrays.stream(nums).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().anyMatch(e -> e.getValue() > 1);
    }
}
