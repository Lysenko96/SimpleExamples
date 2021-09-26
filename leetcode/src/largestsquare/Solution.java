package largestsquare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public int countGoodRectangles(int[][] rectangles) {
		int count = 0;
		List<Integer> minValues = new ArrayList<>();
		for (int i = 0; i < rectangles.length; i++) {
			List<Integer> row = new ArrayList<>();
			for (int j = 0; j < rectangles[i].length; j++) {
				row.add(rectangles[i][j]);
			}
			minValues.add(Collections.min(row));
		}
		int max = Collections.max(minValues);
		for (Integer i : minValues) {
			if (i == max) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().countGoodRectangles(new int[][] { { 5, 7 }, { 4, 3 }, { 7, 3 }, { 6, 7 } }));
	}
}
