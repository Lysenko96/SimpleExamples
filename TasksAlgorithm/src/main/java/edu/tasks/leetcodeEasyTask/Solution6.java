package edu.tasks.leetcodeEasyTask;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution6 {

	// how many jewels repeat in stone

	public Solution6() {
		System.out.println(numJewelsInStones("ebd", "bbb")); // 3
	}

	public static void main(String[] args) {
		new Solution6();
	}

	public int numJewelsInStones(String jewels, String stones) {
		String[] c1 = stones.split("");
		List<String> l = new ArrayList<>();
		for (String w : c1) {
			l.add(w);
		}
		String[] c = jewels.split("");
		Set<String> s = new HashSet<>();
		for (String z : c) {
			s.add(z);
		}
		System.out.println(l);// [b, b, b]
		System.out.println(s); // [b, d, e]
		int count = 0;
		List<String> l2 = new ArrayList<>(s);
		for (int j = 0; j < l2.size(); j++) {
			for (int i = 0; i < l.size(); i++) {
				if (l2.get(j).equals(l.get(i))) {
					count += 1;
				}
			}
		}
		return count;
	}
}
