package edu.tasks.task3;

import java.util.Arrays;

//Two Sum

public class Main {

	Main() {
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 2, 3, 4 }, 4))); // [0, 2]
	}

	public static void main(String[] args) {
		new Main();
	}

	public int[] twoSum(int[] nums, int target) {
		int[] arr = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] + nums[i] == target) {
					arr[0] = j;
					arr[1] = i;
				}
			}
		}
		return arr;
	}
}
