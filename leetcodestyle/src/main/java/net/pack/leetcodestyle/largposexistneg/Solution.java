package net.pack.leetcodestyle.largposexistneg;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findMaxK(new int[]{-10,8,6,7,-2,-3}));
    }

    public int findMaxK(int[] nums) {
        List<Integer> sorted = Stream.of(nums).flatMapToInt(Arrays::stream).boxed().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for(Integer i : sorted){
            if(sorted.contains(i * -1)) return i;
        }
        return -1;
    }
}
