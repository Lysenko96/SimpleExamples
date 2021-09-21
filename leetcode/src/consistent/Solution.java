package consistent;

import java.util.Arrays;

public class Solution {

	public int countConsistentStrings(String allowed, String[] words) {
		int count = 0;

		for (String s : words) {
			int index = 0;
			String[] litters = s.split("");
			for (String w : litters) {
				if (allowed.contains(w)) {
					index++;
				}
			}
			//System.out.println("index " + index);
			//System.out.println("length " + s.length());
			if (index == s.length()) {
				count++;
			}
		}
		//System.out.println(allowed);
		String[] arr = allowed.split("");
		//System.out.println(Arrays.toString(arr));
		return count;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.countConsistentStrings("ab", new String[] { "ad", "bd", "aaab", "baa", "badab" }));
	}
}
