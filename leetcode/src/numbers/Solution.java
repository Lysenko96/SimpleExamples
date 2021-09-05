package numbers;

import java.util.Arrays;

public class Solution {

	public int[] smallerNumbersThanCurrent(int[] nums) {
		Integer[] numsObj = new Integer[nums.length];
		Integer[] tempObj = new Integer[nums.length];
		int[] result = new int[nums.length];
		for (int i = 0; i < tempObj.length; i++) {
			tempObj[i] = Integer.valueOf(nums[i]);
			numsObj[i] = Integer.valueOf(nums[i]);
		}
		Arrays.sort(tempObj);
		for (int i = 0; i < nums.length; i++) {
			int indexElem = Arrays.asList(tempObj).indexOf(numsObj[i]);
			result[i] = indexElem;
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.smallerNumbersThanCurrent(new int[] { 8, 1, 2, 2, 3 });
	}
}
