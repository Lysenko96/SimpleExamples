package net.pack.leetcodestyle.firstmisspositive;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstMissingPositive(new int[]{3,4,0,-1}));
        System.out.println(s.firstMissingPositive(new int[]{1,2,0,-1}));
        System.out.println(s.firstMissingPositive(new int[]{3,4,1,-1}));
        System.out.println(s.firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    public int firstMissingPositive(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> positive = list.stream().filter(x -> x >= 0).collect(Collectors.toList());
        int min = Collections.min(positive);
        int p = 0;
        for (int i = 0; i < positive.size(); i++) {
           if (!positive.contains(i)) {
              p = i;
               System.out.println(p);
           }
        }
        System.out.println();
//        return (int) list.stream().filter(x -> x >= 0).count();
        return 0;
    }
}
