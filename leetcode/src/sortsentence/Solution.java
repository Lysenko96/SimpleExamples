package sortsentence;

import java.util.HashMap;
import java.util.Map;

public class Solution {

	public String sortSentence(String s) {
		String[] words = s.split(" ");
		Map<Integer, String> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			String n = word.substring(word.length() - 1);
			String w = word.substring(0, word.length() - 1);
			map.put(Integer.valueOf(n), w);
		}
		for (Map.Entry<Integer, String> pair : map.entrySet()) {
			sb.append(pair.getValue());
			if (pair.getKey() != words.length) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.sortSentence("Myself2 Me1 I4 and3"));
	}
}
