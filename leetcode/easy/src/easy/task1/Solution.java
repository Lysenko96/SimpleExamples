package easy.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public int[] twoSum(int[] nums, int target) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
		}
		int count = 0;
		for (int i = 0; i < list.size() -1 ; i++) {
			count++;
			int result = 0;
			for (int j = 0; j < list.size(); j++) {
				if (count != j) {
					result = nums[count] + nums[j];
					System.out.println("nums[" + count + "] + nums[" + j + "] " + result);
					if(result == target) {
						return new int[] {count, j};
					}
				}
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.twoSum(new int[] { 4, 7, 11, 1 }, 5)));
	}
}
