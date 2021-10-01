package xorsum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	public int subsetXORSum(int[] nums) {

		List<Integer> l = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			l.add(0 ^ nums[i]);
		}
		System.out.println(l);
		int res = 0;
		int val = 0;
		int temp = 0;
		int t = 0;
		int r = 0;
		// while (!l.isEmpty()) {
		for (int i = 0; i < l.size(); i++) {
			val = 0;
			temp = l.get(i);
			// System.out.println(l);
			l.remove(l.indexOf(temp));
			System.out.println(l);
			for (Integer m : l) {
				val ^= m;
			}
			t += val;
			System.out.println(val);
			l.add(i, temp);
			// System.out.println(l);
			res++;
		}

		System.out.println("t: " + t);
		// l.remove(l.size() - 1);
		// }
		System.out.println(t);
		for (Integer b : l) {
			t += b;
		}
		int z = 0;
		if (l.size() > 2) {
			for (Integer m : l) {
				z ^= m;
			}
		}
		System.out.println(t + z);
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().subsetXORSum(new int[] { 3, 4, 5, 6, 7, 8 }));
	}
}
