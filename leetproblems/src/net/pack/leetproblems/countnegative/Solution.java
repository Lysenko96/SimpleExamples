package net.pack.leetproblems.countnegative;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countNegatives(new int[][]{{1, -2}, {-1, -3}}));
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] < 0){
                    count++;
                }
            }
        }
        return count;
    }
}
