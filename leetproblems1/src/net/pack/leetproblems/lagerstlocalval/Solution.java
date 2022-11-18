package net.pack.leetproblems.lagerstlocalval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(Arrays.deepToString(new Solution().largestLocal(new int[][]{{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}})));
        System.out.println(Arrays.deepToString(new Solution().largestLocal(new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}})));
    }

    public int[][] largestLocal(int[][] grid) {
        //grid = new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 2, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
        int newMatrixLength = grid.length - 2;
        List<Integer> newMatrix = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int m = 0;
        int p = 0;
        for (int k = 0; k < newMatrixLength * newMatrixLength; k++) {
            //System.out.println(p);
            if (p == newMatrixLength) {
                p = 0;
                m++;
            }
            newMatrix = new ArrayList<>();
            for (int i = m; i < 3 + m; i++) {
                for (int j = p; j < 3 + p; j++) {
                    //System.out.print(grid[i][j]);
                    newMatrix.add(grid[i][j]);
                }
            }
            //System.out.print(newMatrix);
            result.add(Collections.max(newMatrix));
            //System.out.println();
            p++;
        }
        //System.out.println(newMatrix);
        int[][] res = new int[newMatrixLength][newMatrixLength];
        int c = 0;
        int d = 0;
        System.out.println(result.size());
        for(int z = 0; z < result.size(); z++){
            if(d == newMatrixLength) { d = 0;}
            res[c][d] = result.get(z);
            d++;
            if(d >= newMatrixLength) c++;
        }
        //System.out.println(Arrays.deepToString(res));
        return res;
    }
}