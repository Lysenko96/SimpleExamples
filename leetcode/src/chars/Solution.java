package chars;

import java.util.LinkedHashMap;
import java.util.Map;

class Solution {

	public String restoreString(String s, int[] indices) {
		char[] chars = s.toCharArray();
		Integer[] indexObj = new Integer[indices.length];
		Character[] charsObj = new Character[s.length()];
		for (int i = 0; i < charsObj.length; i++) {
			charsObj[i] = Character.valueOf(chars[i]);
			indexObj[i] = Integer.valueOf(indices[i]);
		}
		StringBuilder result = new StringBuilder();
		Map<Integer, Character> map = new LinkedHashMap<>();
		for (int i = 0; i < charsObj.length; i++) {
			map.put(indexObj[i], charsObj[i]);
		}
		for (int i = 0; i < map.size(); i++) {
			result.append(map.get(i));
		}
		return result.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.restoreString("codeleet", new int[] { 4, 5, 6, 7, 0, 2, 1, 3 });
	}
}