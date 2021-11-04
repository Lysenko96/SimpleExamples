package selfdividing;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		System.out.println(new Solution().selfDividingNumbers(127, 128));
	}

	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> l = new ArrayList<>();
		for (int i = left; i <= right; i++) {
			int v = i;
			int z = v;
			List<Integer> digits = new ArrayList<>();
			while (v > 0) {
				digits.add(v % 10);
				v /= 10;
			}
			if (!digits.contains(0)) {
				l.add(z);
			}
		}
		List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < l.size(); i++) {
			List<Integer> list = new ArrayList<>();
			int d = l.get(i);
			while (d > 0) {
				int n = d % 10;
				list.add(0, n);
				d /= 10;
			}
			int count = 0;
			for (int j = 0; j < list.size(); j++) {
				if (l.get(i) % list.get(j) == 0) {
					count++;
				}
				if (count == list.size()) {
					list2.add(l.get(i));
				}
			}
		}
		return list2;
	}
}