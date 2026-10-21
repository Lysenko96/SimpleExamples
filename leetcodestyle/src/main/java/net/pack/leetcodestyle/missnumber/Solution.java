package net.pack.leetcodestyle.missnumber;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.missingNumber(new int[]{0, 1}));
    }

    public int missingNumber(int[] nums) {
        int j = 0;
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != j) {
                return j;
            }
            j++;
        }
        return nums.length;
    }
}
