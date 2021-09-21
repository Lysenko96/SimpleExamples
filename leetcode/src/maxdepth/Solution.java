package maxdepth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	public int maxDepth(String s) {
		List<String> chars = Arrays.asList(s.split(""));
		List<String> result = new ArrayList<>();
		List<Integer> max = new ArrayList<>();
		for (String litter : chars) {
			if (litter.equals("(")) {
				result.add(litter);
			} else if (litter.equals(")")) {
				result.remove(result.size() - 1);
			}
			max.add(result.size());
		}
		return Collections.max(max);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxDepth("1"));
	}
}
