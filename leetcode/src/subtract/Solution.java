package subtract;

public class Solution {

	public int subtractProductAndSum(int n) {
		String number = String.valueOf(n);
		char[] chars = number.toCharArray();
		int[] digits = new int[chars.length];
		for (int i = 0; i < digits.length; i++) {
			digits[i] = Integer.valueOf(chars[i] + "");
		}
		int product = 1;
		int sum = 0;
		for (int i = 0; i < digits.length; i++) {
			product *= digits[i];
			sum += digits[i];
		}
		return product - sum;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.subtractProductAndSum(352);
	}
}