package matrixoddvalues;

public class Solution {

	public int oddCells(int m, int n, int[][] indices) {
		int[][] arr = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = 0;
			}
		}

		int count = 0;

		int[][] res = new int[m][n];
		for (int k = 0; k < indices.length; k++) {
			for (int l = 0; l < indices[k].length; l++) {
				// System.out.println(indices[k][l]);
				if (count % 2 == 0) {
					for (int i = 0; i < arr.length; i++) {
						for (int j = 0; j < arr[i].length; j++) {
							if (arr[indices[k][l]][j] % m == 0) {
								res[indices[k][l]][j] += 1;
							}
							arr[indices[k][l]][j] += 1;
						}
					}
				} else if (count % 2 != 0) {
					for (int i = 0; i < arr.length; i++) {
						for (int j = 0; j < arr[i].length; j++) {
							if (arr[i][indices[k][l]] % n == 0) {
								res[i][indices[k][l]] += 1;
							}
							arr[i][indices[k][l]] += 1;
						}
					}
				}
				count++;
			}
		}
		int odd = 0;
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				if (res[i][j] % 2 != 0) {
					odd++;
				}
				// System.out.print(res[i][j]);
			}
			// System.out.println();
		}
		return odd;

	}

	public static void main(String[] args) {
		System.out.println(new Solution().oddCells(2, 3, new int[][] { { 0, 1 }, { 1, 1 } }));
	}
}
