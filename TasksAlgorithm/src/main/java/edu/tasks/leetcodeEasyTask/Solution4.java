package edu.tasks.leetcodeEasyTask;

import java.util.Arrays;

public class Solution4 {

	Solution4() {
		System.out.println(Arrays.toString(shuffle(new int[] { 1, 1, 2, 2 }, 2)));// [1, 2, 1, 2]
	}

	public static void main(String[] args) {
		new Solution4();
	}

	public int[] shuffle(int[] nums, int n) {
		int odd[] = new int[n];
		int even[] = new int[n];
		int arr[] = new int[n * 2];
		int p = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i < nums.length / 2) {
				odd[i] = nums[i];
			} else if (i >= nums.length / 2) {
				even[p] = nums[i];
				p++;
			}
		}
		int z = 0;
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] = odd[z];
				z++;
			} else {
				arr[i] = even[x];
				x++;
			}
		}
		return arr;
	}
}
