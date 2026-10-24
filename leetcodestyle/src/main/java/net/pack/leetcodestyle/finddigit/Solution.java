package net.pack.leetcodestyle.finddigit;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countDigitOccurrences(new int[]{32, 22, 52, 11}, 2));
        System.out.println(s.countDigitOccurrences(new int[]{1, 6, 7, 2}, 2));
        System.out.println(s.countDigitOccurrences(new int[]{1, 22, 222, 2}, 2));
    }

    public int countDigitOccurrences(int[] nums, int digit) {
        return (int) Arrays.stream(nums).mapToLong(x -> Arrays.stream(String.valueOf(x).split(""))
                        .filter(d -> d.equals(String.valueOf(digit)))
                        .count())
                .sum();
    }
}
