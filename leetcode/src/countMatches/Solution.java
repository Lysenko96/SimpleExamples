package countMatches;

public class Solution {

	public int numberOfMatches(int n) {
		if (n == 1) {
			return 0;
		}
		int temp = 0;
		int b = n - 1;
		int result = 0;
		if (n % 2 == 0) {
			while (n != 1) {
				temp = n / 2;
				n -= temp;
				result += temp;
			}
		} else if (n % 2 != 0) {
			while (b >= 1) {
				temp = b / 2 + 1;
				b = b - temp;
				result += temp;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numberOfMatches(3));
	}
}
