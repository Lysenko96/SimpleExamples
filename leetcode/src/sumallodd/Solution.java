package sumallodd;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int sumOddLengthSubarrays(int[] arr) {
		int sum = 0;
		int sum2 = 0;
		List<Integer> l = new ArrayList<>();
		List<Integer> arrList = new ArrayList<>();

		if (arr.length > 2) {
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}

			for (int i = 0; i < arr.length; i++) {
				arrList.add(arr[i]);
			}
			for (int j = 1; j <= arr.length; j++) {
				if (j % 2 != 0) {
					l.add(j);
				}
			}
			// System.out.println(l);
			l.remove(0);

			int index = 0;
			int count = 0;
			int size = l.size() - 1;
			// System.out.println(l);
			if (l.size() > 1) {
				sum += sum;
				for (int k = 0; k < l.size() - 1; k++) {
					for (int i = 0; i < l.get(k); i++) {
						for (int j = count + 0; j < l.get(k) + count; j++) {
							// System.out.print(arrList.get(j) + " ");
							sum2 += arrList.get(j);
						}
						// System.out.println();
						count++;
					}
					count = 0;
					size--;
				}
			} else {
				for (int i = 0; i < l.get(0) - 1; i++) {
					for (int j = count + 0; j < l.get(0) + count; j++) {
						// System.out.print(arrList.get(j) + " ");
						sum2 += arrList.get(j);
					}
					// System.out.println();
					count++;
				}
			}
		} else {
			for (int i = 0; i < arr.length; i++) {
				sum += arr[i];
			}
		}
//		System.out.println(sum);
//		System.out.println(sum2);
		return sum + sum2;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.sumOddLengthSubarrays(new int[] { 10, 11, 12 }));
	}
}
