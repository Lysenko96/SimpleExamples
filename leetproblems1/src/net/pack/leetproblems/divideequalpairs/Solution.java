package net.pack.leetproblems.divideequalpairs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().divideArray(new int[]{3, 2, 3, 2, 2, 2}));
        System.out.println(new Solution().divideArray(new int[]{1,2,3,4}));
    }

    public boolean divideArray(int[] nums) {
        List<Integer> numbers = new ArrayList<>();
        for (Integer number : nums)
            numbers.add(number);

        Map<Integer, Long> map = numbers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(map);
        List<Map.Entry<Integer, Long>> result = map.entrySet().stream().filter(p -> p.getValue() % 2 != 0).toList();
        return result.isEmpty();
    }
}
