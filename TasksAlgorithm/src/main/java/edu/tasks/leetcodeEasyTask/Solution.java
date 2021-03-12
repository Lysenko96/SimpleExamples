package edu.tasks.leetcodeEasyTask;

import java.util.Arrays;

//Running Sum of 1d Array 

class Solution {

	Solution() {
		System.out.println(Arrays.toString(runningSum(new int[] { 1, 2, 3, 4 })));// [1, 3, 6, 10]
	}

	public static void main(String[] args) {
		new Solution();
	}

	public int[] runningSum(int[] nums) {
		for (int i = 0; i < nums.length - 1; i++) {
			nums[i + 1] = nums[i] + nums[i + 1];
		}
		return nums;
	}
}
