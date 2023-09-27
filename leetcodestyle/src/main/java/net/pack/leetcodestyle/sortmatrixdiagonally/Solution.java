//package net.pack.leetcodestyle.sortmatrixdiagonally;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.List;
//
//public class Solution {
//
//    private int cursor;
//
//    public static void main(String[] args) {
//       // System.out.println(Arrays.deepToString(new Solution().diagonalSort(new int[][]{{3, 3, 1, 1}, {2, 2, 1, 2}, {1, 1, 1, 2}})));
//        System.out.println(Arrays.deepToString(new Solution().diagonalSort(new int[][]{{3, 3, 1, 1, 1}, {2, 2, 2, 1, 2}, {4, 1, 1, 1, 2}})));
//    }
//
//    public int[][] diagonalSort(int[][] mat) {
//        int[][] arr = null;
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[i].length; j++) {
//                arr = new int[mat.length][mat[i].length];
//                list.add(mat[i][j]);
//            }
//        }
//        list.sort(Comparator.naturalOrder());
//        int k = 0;
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[i].length; j++) {
//                mat[i][j] = list.get(k);
//                k++;
//            }
//        }
//        int from = 0;
//        int to = 1;
//        int fromNext = 1;
//        int index = 0;
//        for(int i = 0; i < mat.length; i++) {
//            arr = calcStep(arr, cursor, list, from, to, fromNext, index);
//            //System.out.println(Arrays.deepToString(arr));
//            from++;
//            to++;
//            fromNext++;
//            index++;
//        }
//        return arr;
//    }
//
//    private int[][] calcStep(int[][] arr, int cursor, List<Integer> list, int from, int to, int fromNext, int index){
//        for (int i = from; i < to; i++) {
//            for (int j = i; j < arr[i].length; j++) {
//                arr[i][j] = list.get(cursor);
//                cursor++;
//            }
//        }
//        for (int i = fromNext; i < arr.length; i++) {
//            arr[i][index] = list.get(cursor);
//            cursor++;
//        }
//        this.cursor = cursor;
//        return arr;
//    }
//
//}
