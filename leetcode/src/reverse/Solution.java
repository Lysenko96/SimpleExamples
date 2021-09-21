package reverse;

import java.util.*;

public class Solution {

	public int reverse(int x) {
		if (x < Math.pow(2, 31) - 1 && x > (-1) * Math.pow(2, 31)) {
			long z = 0;
			boolean f = false;
			if (x == 0) {
				return 0;
			} else if (x < 0) {
				x = x * (-1);
				f = true;
			}
			List<Long> lInt = new ArrayList<>();
			List<Long> l2 = new ArrayList<>();
			int count = 0;
			int c = 0;
			while (x > 0) {
				c = x % 10;
				lInt.add((long) c);
				x = x / 10;
				count++;
			}

			int p = 1;

			for (int i = 1; i < count; i++) {
				p *= 10;
				l2.add((long) p);
			}
			Collections.reverse(l2);

			for (int i = 0; i < l2.size(); i++) {

				z += lInt.get(i) * l2.get(i);

			}
			z += lInt.get(lInt.size() - 1);
			if (Math.pow(2, 31) < z || z < 0) {
				return 0;
			}
			if (f) {
				z = z * (-1);
			}
			return (int) z;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverse(15342));
	}
}