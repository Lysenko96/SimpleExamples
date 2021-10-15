package chessboard;

public class Solution {

	public boolean squareIsWhite(String coordinates) {

		boolean[][] arr = getArray();

		arr = getBoard(arr);

		return isWhite(coordinates, arr);
	}

	boolean[][] getArray() {
		int count = 0;
		boolean[][] arr = new boolean[8][8];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (count % 2 != 0) {
					arr[i][j] = true;
				} else {
					arr[i][j] = false;
				}
				count++;
			}
		}
		return arr;
	}

	boolean[][] getBoard(boolean[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (i % 2 != 0) {
				for (int j = 0; j < arr[i].length; j++) {
					if (arr[i][j]) {
						arr[i][j] = false;
					} else if (!arr[i][j]) {
						arr[i][j] = true;
					}
				}
			}
		}
		return arr;
	}

	boolean isWhite(String coordinates, boolean[][] arr) {
		String[] points = new String[] { "a", "b", "c", "d", "e", "f", "g", "h" };
		String[] values = coordinates.split("");
		int point = 0;
		for (int i = 0; i < points.length; i++) {
			if (points[i].equals(values[0])) {
				point = i;
			}
		}
		int point2 = Integer.valueOf(values[1]) - 1;
		return arr[point][point2];
	}

	public static void main(String[] args) {
		System.out.println(new Solution().squareIsWhite("e5"));
	}
}