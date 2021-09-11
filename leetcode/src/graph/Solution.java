package graph;

public class Solution {

	public int findCenter(int[][] edges) {
		int count = 0;
		int result = 0;
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[i].length; j++) {
				if (edges[i][j] == edges[0][0]) {
					count++;
				}
			}
		}
		if (count == edges.length) {
			result = edges[0][0];
		} else {
			result = edges[0][1];
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findCenter(new int[][] { { 2, 3 }, { 2, 4 }, { 5, 2 } }));
	}
}
