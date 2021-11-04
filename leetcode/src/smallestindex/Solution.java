package smallestindex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().smallestEqual(new int[] { 4, 5, 6, 9, 9, 5, 9, 0, 8 }));
	}

	public int smallestEqual(int[] nums) {
		List<Integer> mods = new ArrayList<>();
		List<Integer> l = new ArrayList<>();
		for (Integer i : nums) {
			l.add(i);
		}
		for (int i = 0; i < l.size(); i++) {
			if (i % 10 == l.get(i)) {
				mods.add(i);
			}
		}
		if (mods.isEmpty()) {
			return -1;
		}
		return Collections.min(mods);
	}
}