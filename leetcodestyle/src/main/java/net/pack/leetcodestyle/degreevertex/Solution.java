package net.pack.leetcodestyle.degreevertex;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findDegrees(new int[][]{{0,1,1},{1,0,1},{1,1,0}});
        s.findDegrees(new int[][]{{0}});
    }

    public int[] findDegrees(int[][] matrix) {
        int counter = 0;
        int[] arr = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    counter++;
                }
            }
            arr[i] = counter;
            counter = 0;
        }
//        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
