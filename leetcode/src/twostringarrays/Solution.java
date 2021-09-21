package twostringarrays;

public class Solution {

	public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb1 = new StringBuilder();
		for (String s : word1) {
			sb.append(s);
		}
		for (String s : word2) {
			sb1.append(s);
		}
		return sb.toString().equals(sb1.toString());
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(
				solution.arrayStringsAreEqual(new String[] { "abc", "d", "defg" }, new String[] { "abcddefg" }));
	}
}
