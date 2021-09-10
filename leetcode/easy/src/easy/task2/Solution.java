package easy.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public int reverse(int x) {
		int z = 0;
		boolean f = false;
		if (x == 0) {
			return z;
		} else if (x < 0) {
			x = x * (-1);
			f = true;
		}
		List<Integer> lInt = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();

		int count = 0;
		int c = 0;
		while (x > 0) {
			c = x % 10;
			lInt.add(c);
			x = x / 10;
			count++;
		}

		int p = 1;
		for (int i = 1; i < count; i++) {
			p *= 10;
			l2.add(p);
		}
		Collections.reverse(l2);

		for (int i = 0; i < l2.size(); i++) {
			z += lInt.get(i) * l2.get(i);
		}
		z += lInt.get(lInt.size()-1);
		if(f == true) {
			z = z * (-1);
			return z;
		}
		return z;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		 System.out.println( solution.reverse(-12));
	}
}
