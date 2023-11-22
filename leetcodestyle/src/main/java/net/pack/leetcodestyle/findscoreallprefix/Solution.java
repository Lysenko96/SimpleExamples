package net.pack.leetcodestyle.findscoreallprefix;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findPrefixScore(new int[]{2,3,7,5,10});
        solution.findPrefixScore(new int[]{1,1,2,4,8,16});
    }

    public long[] findPrefixScore(int[] nums) {
        long[] score = new long[nums.length];
        long sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(max < nums[i]) max = nums[i];
            score[i] = sum += nums[i] + max;
        }
        return score;
    }
}
