package replace;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	String[] alphabet = "abcdefghijklmnopqrstuvwxyz".split("");

	public String replaceDigits(String s) {
		List<String> letters = new ArrayList<>();
		for (String letter : alphabet) {
			letters.add(letter);
		}
		StringBuilder result = new StringBuilder();
		String[] str = s.split("");
		if (s.length() % 2 == 0) {
			for (int i = 0; i < str.length - 1; i += 2) {
				int index = letters.indexOf(str[i]);
				int index2 = Integer.valueOf(letters.indexOf(str[i])) + Integer.valueOf(str[i + 1]);
				result.append(letters.get(index)).append(letters.get(index2));
			}
		} else {
			for (int i = 0; i < str.length - 1; i += 2) {
				int index = letters.indexOf(str[i]);
				int index2 = Integer.valueOf(letters.indexOf(str[i])) + Integer.valueOf(str[i + 1]);
				result.append(letters.get(index)).append(letters.get(index2));
			}
			result.append(str[str.length - 1]);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.replaceDigits("v0g6s4d"));
	}
}
