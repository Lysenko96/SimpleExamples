package maxproduct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public int maxProductDifference(int[] nums) {
		int max1 = 0;
		int max2 = 0;
		int min1 = 0;
		int min2 = 0;
		List<Integer> digits = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			digits.add(nums[i]);
		}
		max1 = Collections.max(digits);
		digits.remove(digits.indexOf(max1));
		max2 = Collections.max(digits);
		min1 = Collections.min(digits);
		digits.remove(digits.indexOf(min1));
		min2 = Collections.min(digits);
		return max1 * max2 - min1 * min2;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxProductDifference(new int[] { 4, 2, 5, 9, 7, 4, 8 }));
	}

}
