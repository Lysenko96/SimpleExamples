package triplets;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int countGoodTriplets(int[] arr, int a, int b, int c) {

		List<List<Integer>> triplets = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					List<Integer> part = new ArrayList<>();
					if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
							&& Math.abs(arr[i] - arr[k]) <= c) {
						part.add(arr[i]);
						part.add(arr[j]);
						part.add(arr[k]);
						triplets.add(part);
						count++;
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.countGoodTriplets(new int[] { 7, 3, 7, 3, 12, 1, 12, 2, 3 }, 5, 8, 1);
	}
}
