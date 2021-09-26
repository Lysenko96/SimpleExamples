package max69;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public int maximum69Number(int num) {
		List<Integer> res = new ArrayList<>();
		List<Integer> numbers = new ArrayList<>();

		while (num > 0) {
			res.add(num % 10);
			num /= 10;
		}
		if (res.contains(6)) {
			for (int i = 0; i < res.size(); i++) {
				if (res.get(i).equals(9)) {
					res.set(i, 6);
				} else if (res.get(i).equals(6)) {
					res.set(i, 9);
				}
				// System.out.println(res);
				int result = 0;
				for (int j = 1; j < res.size(); j++) {
					result += (int) Math.pow(10, j) * res.get(j);

				}
				numbers.add(result + res.get(0));
				if (res.get(i).equals(6)) {
					res.set(i, 9);
				} else if (res.get(i).equals(9)) {
					res.set(i, 6);
				}
			}
		} else {
			int result1 = 0;
			for (int j = 1; j < res.size(); j++) {
				result1 += (int) Math.pow(10, j) * res.get(j);

			}
			return result1 + res.get(0);
		}

		return Collections.max(numbers);
	}

	public static void main(String[] args) {
		System.out.println(new Solution().maximum69Number(99));
	}
}
