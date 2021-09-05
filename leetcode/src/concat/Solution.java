package concat;

import java.util.Arrays;

public class Solution {

	public int[] getConcatenation(int[] nums) {
		int d = 0;
		int k = nums.length;
		int result[] = new int[nums.length * 2];
		for (int i = 0; i < nums.length; i++) {
			result[d] += nums[i];
			result[k] += nums[i];
			d++;
			k++;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.getConcatenation(new int[] { 1, 3, 2, 1 })));
	}
}
