package maxproduct2elem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public int maxProduct(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i != j) {
					list.add((nums[i] - 1) * (nums[j] - 1));
				}
			}
		}
		return Collections.max(list);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maxProduct(new int[] { 1, 5, 3, 4 }));
	}
}