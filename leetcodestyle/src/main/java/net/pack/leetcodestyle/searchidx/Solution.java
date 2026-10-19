package net.pack.leetcodestyle.searchidx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.targetIndices(new int[]{1,2,5,2,3},2));
        System.out.println(s.targetIndices(new int[]{1,2,5,2,3},5));
        System.out.println(s.targetIndices(new int[]{1,2,5,2,3},3));

    }

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> idx = new ArrayList<>();
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] == target) {
                idx.add(i);
            }
        }
        return idx;
    }
}
