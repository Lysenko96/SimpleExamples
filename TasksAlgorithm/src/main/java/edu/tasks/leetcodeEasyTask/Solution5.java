package edu.tasks.leetcodeEasyTask;

//Number of Good Pairs
// A pair (i,j) is called good if nums[i] == nums[j] and i < j

public class Solution5 {

	Solution5() {
		System.out.println(numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
	}

	public static void main(String[] args) {
		new Solution5();
	}

	public int numIdenticalPairs(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[i] == nums[j] && i < j) {
					count++;
				}
			}
		}
		return count;
	}
}
