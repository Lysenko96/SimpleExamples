package net.pack.leetcodestyle.searchinsert;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1, 3, 5, 6};
        System.out.println(solution.searchInsert(arr, 5));
        System.out.println(solution.searchInsert(arr, 2));
        System.out.println(solution.searchInsert(arr, 7));
    }

    public int searchInsert(int[] nums, int target) {
        return (int) Arrays.stream(nums).filter(n -> n < target).count();
    }
}
