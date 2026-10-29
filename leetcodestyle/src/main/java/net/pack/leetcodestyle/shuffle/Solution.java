package net.pack.leetcodestyle.shuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.permute(new int[]{1,2,3});
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = 1;
        for (int i = 1; i <= nums.length; i++) {
            n *= i;
        }
        System.out.println(n);
        List<List<Integer>> result = new ArrayList<>();
        int id = 0;
        while (id != n) {
            List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
            Collections.shuffle(l);
            if (!result.contains(l)) {
                result.add(l);
                id++;
            }
        }
        System.out.println(result);
        return result;
    }
}
