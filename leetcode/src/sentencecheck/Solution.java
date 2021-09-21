package sentencecheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

	public boolean checkIfPangram(String sentence) {
		List<Character> result = new ArrayList<>();
		boolean f = false;
		List<Character> alphabet = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
				'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
		char[] chars = sentence.toCharArray();

		for (int i = 0; i < chars.length; i++) {
			result.add(chars[i]);
		}
		int index = 0;
		for (Character ch : alphabet) {
			if (result.contains(ch)) {
				index++;
			}
		}
		if (index >= alphabet.size()) {
			f = true;
		} else {
			f = false;
		}
		return f;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.checkIfPangram("leetcode"));
	}
}
