package net.pack.leetcodestyle.pointsinsidecircle;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.countPoints(new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}}, new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}})));
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int counter = 0;
        int pointCounter = 0;
        int[] arrQueryPoints = new int[queries.length];
        for (int[] query : queries) {
            for (int[] point : points) {
                double d = Math.sqrt(Math.pow(point[0] - query[0], 2) + Math.pow(point[1] - query[1], 2));
                if (d <= query[2]) {
                    pointCounter++;
                }
            }
            arrQueryPoints[counter] = pointCounter;
            pointCounter = 0;
            counter++;
        }
        return arrQueryPoints;
    }
}
