//package net.pack.leetcodestyle.diffonezerorowcolumn;
//
//import java.util.Arrays;
//
//public class Solution {
//
//    public static void main(String[] args) {
////        new Solution().onesMinusZeros(new int[][]{{0, 1, 1}, {1, 0, 1}, {0,0,1}});
//        new Solution().onesMinusZeros(new int[][]{{1}});
//        // new Solution().onesMinusZeros(new int[][]{{1,1,0,1,0}});
//        // new Solution().onesMinusZeros(new int[][]{{0}, {0}, {0}, {0}, {0}});
//        // new Solution().onesMinusZeros(new int[][]{{1, 0, 0, 0, 1}});
//    }
//
//    public int[][] onesMinusZeros(int[][] grid) {
//        int length = grid.length;
//        if (grid.length > 1) length = grid[1].length;
//        int[] arrFirst = new int[grid.length];
//        int[] arrSecond = new int[length];
//        int[] arrThird = new int[grid.length];
//        int[] arrFourth = new int[length];
//        int[] arrFifth = new int[grid.length * length];
//        int[] arrSixth = new int[grid.length * length];
//
//        boolean onlyZero = false;
//        int counter = 0;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == 0) counter++;
//            }
//            if (counter == grid.length * grid[i].length) onlyZero = true;
//        }
//        if (onlyZero) {
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    if (grid[i][j] == 0) grid[i][j] = -2 - (grid.length * grid[i].length - 1);
//                }
//            }
//            // System.out.println(Arrays.deepToString(grid));
//            return grid;
//        } else if (grid[0].length == 1 && grid[0][0] == 1) {
//            return new int[][]{{2}};
//        } else if (grid.length == 1) {
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    if (grid[i][j] == 0) grid[i][j] = -2;
//                    else grid[i][j] = 0;
//                }
//            }
//            return grid;
//        }
//
//
//        int z = 0;
//        for (int i = 0; i < grid.length; i++) {
//            int rowSumOne = 0;
//            int rowSumZero = 0;
//            for (int j = 0; j < grid[i].length; j++) {
//                if (grid[i][j] == 1) rowSumOne++;
//                if (grid[i][j] == 0) rowSumZero++;
//                arrFirst[z] = rowSumOne;
//                arrThird[z] = rowSumZero;
//            }
//            z++;
//        }
//        z = 0;
//        for (int i = 0; i < length; i++) {
//            int columnSumOne = 0;
//            int columnSumZero = 0;
//            for (int j = 0; j < grid.length; j++) {
//                if (grid[j][i] == 1) columnSumOne++;
//                if (grid[j][i] == 0) columnSumZero++;
//                arrSecond[z] = columnSumOne;
//                arrFourth[z] = columnSumZero;
//            }
//            z++;
//        }
//        z = 0;
////        System.out.println(Arrays.toString(arrFirst));
////        System.out.println(Arrays.toString(arrSecond));
//
//        for (int i = 0; i < arrFirst.length; i++) {
//            for (int j = 0; j < arrSecond.length; j++) {
//                arrFifth[z] = arrFirst[i] + arrSecond[j];
//                z++;
//            }
//        }
//        z = 0;
////        System.out.println(Arrays.toString(arrThird));
////        System.out.println(Arrays.toString(arrFourth));
//        for (int i = 0; i < arrThird.length; i++) {
//            for (int j = 0; j < arrFourth.length; j++) {
//                arrSixth[z] = arrThird[i] + arrFourth[j];
//                z++;
//            }
//        }
//        z = 0;
////        System.out.println(Arrays.toString(arrFifth));
////        System.out.println(Arrays.toString(arrSixth));
//        if (grid.length == 1) {
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    if (grid[i][j] != 0) grid[i][j] = arrFifth[i] - arrSixth[i];
//                    z++;
//                }
//            }
//        } else {
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    grid[i][j] = arrFifth[z] - arrSixth[z];
//                    z++;
//                }
//            }
//        }
//        //System.out.println(Arrays.deepToString(grid));
//        return grid;
//    }
//}
