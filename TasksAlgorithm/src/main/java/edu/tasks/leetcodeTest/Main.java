package edu.tasks.leetcodeTest;

import java.util.Arrays;

//Two Sum

public class Main {

	Main() {
		System.out.println(Arrays.toString(twoSum(new int[] { 2, 5, 5, 11 }, 10))); // [2, 0, 0, 11]
	}

	public static void main(String[] args) {
		new Main();
	}

	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 1; j < nums.length - 1; j++) {
				if (nums[j] + nums[i] == target) {
					nums[j] = 0;
					nums[i] = 0;
				}
			}
		}
		return nums;
	}
}
