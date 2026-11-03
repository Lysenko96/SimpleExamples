package net.pack.leetcodestyle.concatarrrevers;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.concatWithReverse(new int[]{1, 2, 3});
    }

    public int[] concatWithReverse(int[] nums) {
        int[] arr = new int[nums.length * 2];
        int j = nums.length - 1;
        for (int i = 0; i < nums.length * 2; i++) {
            if (i <= nums.length - 1) {
                arr[i] = nums[i];
            } else {
                arr[i] = nums[j];
                j--;
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
