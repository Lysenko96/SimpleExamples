package easy.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public int reverse(int x) {
		List<Integer> lInt = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		int count = 0;
		int c = 0 ;
		while (x > 0) {
			c = x % 10;
			System.out.println(c);
			lInt.add(c);
			x = x / 10;
			count++;
		}
		int p = 1;
		for(int i = 1; i < count; i++) {
			p *= 10;
			l2.add(p);
		}
		Collections.reverse(l2);
		int z = 0;
		for(int i = 0; i < l2.size(); i++) {
			z += lInt.get(i) * l2.get(i);
		}
		z += lInt.get(lInt.size()-1);
		System.out.println(z);
		return z;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.reverse(1245);
	}
}
