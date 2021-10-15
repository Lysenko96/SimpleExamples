package sumtozero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// solve but need tests
public class Solution {

	Random rand = new Random();

	public int[] sumZero(int n) {
		int b = 100;
		int a = -100;
		while (true) {
			List<Integer> l = new ArrayList<>();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				l.add(a + rand.nextInt(b - a + 1));
			}
			for (Integer i : l) {
				sum += i;
			}
			if (sum == 0) {
				int[] arr = new int[n];
				for (int i = 0; i < l.size(); i++) {
					arr[i] = l.get(i);
				}
				return arr;
			}
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.sumZero(23)));
	}
}