package net.pack.leetproblems.delgreatestvaluerow;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().deleteGreatestValue(new int[][]{{1, 2, 4}, {3, 3, 1}}));
        //System.out.println(new Solution().deleteGreatestValue(new int[][]{{1, 2, 4, 5}, {3, 3, 1, 1}}));
    }

    public int deleteGreatestValue(int[][] grid) {
        List<Integer> sum = new ArrayList<>();
        List<List<Integer>> gridList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                row.add(grid[i][j]);
            }
            gridList.add(row);
        }
        //System.out.println(gridList);
        gridList = checkList(gridList, sum);
        //System.out.println(gridList);
        //System.out.println(sum);
        int result = 0;
        for(Integer val : sum)
            result += val;
        return result;
    }

    public List<List<Integer>> checkList(List<List<Integer>> gridList, List<Integer> sum) {
        while (gridList.get(0).size() >= 1) {
            List<Integer> max = new ArrayList<>();
            for (List<Integer> list : gridList) {
                Iterator<Integer> iterator = list.iterator();
                List<Integer> row = new ArrayList<>();
                while (iterator.hasNext()) {
                    Integer value = iterator.next();
                    row.add(value);
                    //   System.out.println(row);
                }
                max.add(Collections.max(row));
                // System.out.println(max);
            }
            sum.add(Collections.max(max));
            //System.out.println(sum);
//            for (int i = 0; i < grid.length; i++) {
//                List<Integer> row = new ArrayList<>();
//                for (int j = 0; j < grid[i].length; j++) {
//                    //System.out.println(grid[i][j]);
//                    row.add(grid[i][j]);
//                    System.out.println(row);
//                }
//                System.out.println(Collections.max(row));
//                max.add(Collections.max(row));
//            }
//            sum.add(Collections.max(max));
//            System.out.println(sum);
            int p = 0;
            for (List<Integer> list : gridList) {
                Iterator<Integer> iterator = list.iterator();
                while (iterator.hasNext()) {
                    Integer value = iterator.next();
                    if (value.equals(max.get(p))) {
                        iterator.remove();
                        p++;
                        break;
                    }
                }
            }
            //System.out.println(gridList);
        }
        return gridList;
    }
}
