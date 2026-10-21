package net.pack.leetcodestyle.transpomatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
        System.out.println(Arrays.deepToString(s.transpose(new int[][]{{1, 2, 3}, {4, 5, 6}})));

    }

    public int[][] transpose(int[][] matrix) {
        int[][] newMatrix = new int[][]{};
        int l1 = 0;
        for (int i = 0; i < matrix.length; i++) {
            newMatrix = new int[matrix[i].length][matrix.length];
            l1 = matrix[i].length;
        }
        List<Integer> ll = new ArrayList<>();
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < matrix.length; j++) {
                ll.add(matrix[j][i]);
            }
        }
//        System.out.println(ll);
        int idx = 0;
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                newMatrix[i][j] = ll.get(idx);
                idx++;
            }
        }
//        System.out.println(Arrays.deepToString(newMatrix));
        return newMatrix;
    }
}
