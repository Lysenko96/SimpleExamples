package net.pack.leetcodestyle.leftrightsumdiff;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().leftRigthDifference(new int[]{10,4,8,3})));
    }

    public int[] leftRigthDifference(int[] nums) {
        if(nums.length == 1) return new int[]{0};
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        int[] answer = new int[nums.length];
        int leftIndex = 0;
        int rightIndex = nums.length-1;
        int sumLeft = 0;
        int sumRight = 0;
        while (leftIndex <= nums.length-1 && rightIndex != 0) {
            sumLeft += nums[leftIndex];
            sumRight += nums[rightIndex];
            leftSum[leftIndex + 1] += sumLeft;
            rightSum[rightIndex - 1] += sumRight;
            leftIndex++;
            rightIndex--;
        }
        for(int i = 0; i < nums.length; i++) {
            answer[i] = Math.abs(leftSum[i] - rightSum[i]);
        }
        return answer;
    }
}
