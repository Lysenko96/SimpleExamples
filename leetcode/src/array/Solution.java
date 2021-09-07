package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public int[] createTargetArray(int[] nums, int[] index) {

		List<Integer> l = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			l.add(index[i], nums[i]);
		}
		int[] arr = new int[l.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = l.get(i);
		}
		return arr;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(
				Arrays.toString(solution.createTargetArray(new int[] { 1, 2, 3, 4, 0 }, new int[] { 0, 1, 2, 3, 0 })));
	}
}
