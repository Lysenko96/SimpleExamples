package reduce;

public class Solution {

	public int numberOfSteps(int num) {
		int count = 0;
		while (num > 0) {
			if (num % 2 == 1) {
				num = num - 1;
				count++;
			}
			if (num != 0) {
				num = num / 2;
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.numberOfSteps(123);
	}
}