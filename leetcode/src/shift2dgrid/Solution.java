package shift2dgrid;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(new Solution().shiftGrid(new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12,0,21,13}}, 4));
        System.out.println(new Solution().shiftGrid(new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12,0,21,13}}, 1));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> numbers = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        int n = 0;
        int m = 0;
        for (int i = 0; i < grid.length; i++) {
            m = 0;
            for (int j = 0; j < grid[i].length; j++) {
                m++;
                numbers.add(grid[i][j]);
            }
            n++;
        }
       // System.out.println(n);
       // System.out.println(m);
      //  System.out.println(numbers);
        for(int i = 0; i < k; i++) {
            int temp = numbers.get(numbers.size()-1);
            numbers.remove(numbers.size() - 1);
            numbers.add(0, temp);
        }
       // System.out.println(numbers);
        int count = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> line = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                line.add(numbers.get(count));
                count++;
            }
            result.add(line);
            //System.out.println(line);
        }
        //System.out.println(result);
        return result;
    }
}
