package checkcharequalnumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public boolean areOccurrencesEqual(String s) {
		String[] arr = s.split("");
		List<String> res = List.of(arr);
		return calcWorld(res);
	}

	boolean calcWorld(List<String> list) {
		String key = "";
		boolean f = false;
		Map<String, Integer> map = new HashMap<>();
		for (String line : list) {
			key = line;
			int value = 0;
			if (!map.containsKey(line)) {
				map.put(line, 1);
			} else if (map.containsKey(line)) {
				value = map.get(line) + 1;
				map.put(line, value);
			}
		}
		int res = map.get(key);
		if (map.size() > 1) {
			List<String> result = new ArrayList<>();
			for (Map.Entry<String, Integer> pair : map.entrySet()) {
				if (pair.getValue() == res) {
					result.add(pair.getKey());
				}
			}
			f = result.size() == map.size();
		} else if (map.size() == 1) {
			f = true;
		}
		return f;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().areOccurrencesEqual("aaabb"));
	}
}