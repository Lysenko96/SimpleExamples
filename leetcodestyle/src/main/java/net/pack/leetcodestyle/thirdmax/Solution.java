package net.pack.leetcodestyle.thirdmax;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.thirdMax(new int[]{1, 2}));
        System.out.println(s.thirdMax(new int[]{1, 1, 3, 3, 5, 5, 4, 4, 4}));
    }

    public int thirdMax(int[] nums) {
        Set<Integer> numbers = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (numbers.size() <= 2) {
            return Collections.max(numbers);
        }
        int firstMax = Collections.max(numbers);
        numbers.remove(firstMax);
        int secondMax = Collections.max(numbers);
        numbers.remove(secondMax);
        return Collections.max(numbers);
    }
}
