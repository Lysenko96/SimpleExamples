package morse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	String[] morse = new String[] { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
			".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
			"--.." };
	String[] alpabet = "abcdefghijklmnopqrstuvwxyz".split("");

	Set<String> set = new HashSet<>();
	
	public int uniqueMorseRepresentations(String[] words) {
		List<String> strings = new ArrayList<>();
		for (String str : alpabet) {
			strings.add(str);
		}
		for (String word : words) {
			String[] letters = word.split("");
			StringBuilder sb = new StringBuilder();
			for (String s : letters) {
			//	System.out.print(morse[strings.indexOf(s)]);
				sb.append(morse[strings.indexOf(s)]);
			}
			set.add(sb.toString());
			//System.out.println();
		}
		System.out.println(set);
		return set.size();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" });
	}
}