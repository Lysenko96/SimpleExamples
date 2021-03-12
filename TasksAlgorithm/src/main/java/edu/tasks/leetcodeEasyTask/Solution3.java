package edu.tasks.leetcodeEasyTask;

import java.util.Arrays;

// Richest Customer Wealth

public class Solution3 {

	Solution3() {
		System.out.println(maximumWealth(new int[][] { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } })); // 17
	}

	public static void main(String[] args) {
		new Solution3();
	}

	public int maximumWealth(int[][] accounts) {
		int arr[] = new int[accounts.length];
		for (int i = 0; i < accounts.length; i++) {
			int max = 0;
			for (int j = 0; j < accounts[i].length; j++) {
				max += accounts[i][j];
			}
			arr[i] = max;
		}
		Arrays.sort(arr);
		int val = arr[arr.length - 1];
		return val;
	}
}
