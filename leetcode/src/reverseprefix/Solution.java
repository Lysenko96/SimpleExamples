package reverseprefix;

public class Solution {

	public String reversePrefix(String word, char ch) {
		char[] chars = word.toCharArray();
		int index = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == ch) {
				index = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = index; i >= 0; i--) {
			sb.append(chars[i]);
		}
		for (int i = index + 1; i < chars.length; i++) {
			sb.append(chars[i]);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reversePrefix("abcdefd", 'd'));
	}
}
