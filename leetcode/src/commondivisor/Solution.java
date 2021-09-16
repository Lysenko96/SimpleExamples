package commondivisor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public int findGCD(int[] nums) {
		List<Integer> digits = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			digits.add(nums[i]);
		}
		int max = Collections.max(digits);
		int min = Collections.min(digits);
		int result = 0;
		int temp = min;
		// System.out.println(max);
		// System.out.println(min);
		if (max % min == 0) {
			result = min;
		} else {
			for (int i = min; i > 0; i--) {
				if (max % i == 0 && temp % i == 0) {
					// System.out.println(i);
					return i;
				}
			}
		}
		// System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findGCD(new int[] { 7, 5, 6, 8, 3 }));
	}
}
