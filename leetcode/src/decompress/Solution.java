package decompress;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public int[] decompressRLElist(int[] nums) {
		int i = 0;
		List<Integer> list = new ArrayList<>();
		while (i < nums.length - 1) {
			if (i % 2 == 0) {
				for (int j = 0; j < nums[i]; j++) {
					list.add(nums[i + 1]);
				}
			}
			i++;
		}
		int[] result = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			result[k] = list.get(k);
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.decompressRLElist(new int[] { 1, 2, 3, 4 })));
	}
}
