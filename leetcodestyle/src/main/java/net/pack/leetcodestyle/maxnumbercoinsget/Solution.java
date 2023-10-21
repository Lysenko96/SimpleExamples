//package net.pack.leetcodestyle.maxnumbercoinsget;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class Solution {
//
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(solution.maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
//    }
//
//    public int maxCoins(int[] piles) {
//       // List<Integer> shuffle = new ArrayList<>();
//        //for (Integer number : piles) shuffle.add(number);
//
//        //Collections.shuffle(shuffle);
//       // System.out.println(shuffle);
//        // 1 2 2 4 7 8
//        // 1 4
//        // 2 7
//        // 2 8
//        // 9 8 7 6 5 1 2 3 4
//        // 1 2 7
//        // 2 5 8
//        // 3 6 9
//        int k = 1;
//        int sum = 0;
//        for (int i = 0; i < piles.length; i++) {
//            if (i == k) {
//                sum += piles[i];
//                k += 3;
//            }
//        }
//        return sum;
//    }
//}
