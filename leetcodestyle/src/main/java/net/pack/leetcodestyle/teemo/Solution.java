package net.pack.leetcodestyle.teemo;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findPoisonedDuration(new int[]{1, 4}, 2));
        System.out.println(s.findPoisonedDuration(new int[]{1, 2}, 2));
        System.out.println(s.findPoisonedDuration(new int[]{1, 2}, 4));
    }

//    public int findPoisonedDuration(int[] timeSeries, int duration) {
//        List<List<Integer>> intervals = new ArrayList<>();
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < timeSeries.length; i++) {
//            intervals.add(Arrays.asList(timeSeries[i], timeSeries[i] + duration - 1));
//            for (int j = intervals.get(i).get(0); j <= intervals.get(i).get(1); j++) {
//                set.add(j);
//            }
//        }
//        return set.size();
//    }

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0;
        for (int i = 0; i < timeSeries.length; i++) {
            if (i == timeSeries.length - 1) {
                total += duration;
            } else {
                total += Math.min(timeSeries[i + 1] - timeSeries[i], duration);
            }
        }
        return total;
    }
}
