package permutation;

public class Solution {

	public int[] buildArray(int[] nums) {
		int ans[] = new int[nums.length];

		for (int i = 0; i < ans.length; i++) {
			ans[i] = nums[nums[i]];
		}
		return ans;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.buildArray(new int[] { 0, 2, 1, 5, 3, 4 });
	}
}
