package edu.tasks.leetcodeEasyTask;

import java.util.Arrays;
import java.util.List;

//Kids With the Greatest Number of Candies

public class Solution2 {

	Solution2() {
		System.out.println(kidsWithCandies(new int[] { 2, 3, 5, 1, 3 }, 3)); // [true, true, true, false, true]
	}

	public static void main(String[] args) {
		new Solution2();
	}

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = candies[0];
		for (int i = 0; i < candies.length; i++) {
			if (max < candies[i]) {
				max = candies[i];
			}
		}
		Boolean[] arr = new Boolean[candies.length];
		for (int i = 0; i < candies.length; i++) {
			if (candies[i] + extraCandies >= max) {
				arr[i] = true;
			} else if (candies[i] + extraCandies < max) {
				arr[i] = false;
			}
		}
		return Arrays.asList(arr);
	}
}
