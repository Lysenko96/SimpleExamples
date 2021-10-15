package destcity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

	public String destCity(List<List<String>> paths) {
		String result = "";
		List<String> all = new ArrayList<>();
		for (List<String> path : paths) {
			for (String point : path) {
				all.add(point);
			}
		}
		for (List<String> path : paths) {
			for (String s : calcWorld(all)) {
				if (path.get(1).equals(s)) {
					result = path.get(1);
				}
			}
		}
		return result;
	}

	List<String> calcWorld(List<String> list) {
		Map<String, Integer> map = new HashMap<>();
		for (String line : list) {
			int value = 0;
			if (!map.containsKey(line)) {
				map.put(line, 1);
			} else if (map.containsKey(line)) {
				value = map.get(line) + 1;
				map.put(line, value);
			}
		}
		List<String> result = new ArrayList<>();
		for (Map.Entry<String, Integer> pair : map.entrySet()) {
			if (pair.getValue() == 1) {
				result.add(pair.getKey());
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().destCity(
				List.of(List.of("London", "New York"), List.of("New York", "Lima"), List.of("Lima", "Sao Paulo"))));
	}
}