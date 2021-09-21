package words;

public class Solution {

	public String truncateSentence(String s, int k) {
		String[] res = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < k; i++) {
			sb.append(res[i]);
			if (i < k - 1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.truncateSentence("Hello how are you Contestant", 4));
	}
}
