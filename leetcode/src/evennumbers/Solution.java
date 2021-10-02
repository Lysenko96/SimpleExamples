package evennumbers;

public class Solution {

	public int findNumbers(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			String[] s = String.valueOf(nums[i]).split("");
			if (s.length % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().findNumbers(new int[] { 555, 901, 482, 1771 }));
	}
}