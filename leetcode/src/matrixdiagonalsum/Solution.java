package matrixdiagonalsum;

public class Solution {

	public int diagonalSum(int[][] mat) {
		int j = mat.length - 1;
		int res = 0;
		if (mat.length % 2 != 0) {
			for (int i = 0; i < mat.length; i++) {
				res += mat[i][i] + mat[i][j];
				j--;
			}
			int elem = mat[mat.length / 2][mat.length / 2];
			res -= elem;
		} else {
			for (int i = 0; i < mat.length; i++) {
				res += mat[i][i] + mat[i][j];
				j--;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new Solution().diagonalSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
	}
}