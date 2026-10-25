package net.pack.leetcodestyle.minsum;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minOperations(new int[]{3, 9, 7}, 5));
        System.out.println(s.minOperations(new int[]{4, 1, 3}, 4));
        System.out.println(s.minOperations(new int[]{3, 2}, 6));
        System.out.println(s.minOperations(new int[]{18, 11}, 18));
    }

    public int minOperations(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        int counter = 0;
        while (sum % k != 0) {
            sum--;
            counter++;
        }
        return counter;
    }
}
