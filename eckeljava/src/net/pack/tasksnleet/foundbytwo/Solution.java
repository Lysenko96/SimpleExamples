package net.pack.tasksnleet.foundbytwo;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findFinalValue(new int[]{8,19,4,2,15,3}, 2));
    }

    public int findFinalValue(int[] nums, int original) {
        int val = original;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (val == nums[i]) {
                //System.out.println(nums[i]);
                val *= 2;
            }
        }
        //System.out.println(val);
        return val;
    }
}
