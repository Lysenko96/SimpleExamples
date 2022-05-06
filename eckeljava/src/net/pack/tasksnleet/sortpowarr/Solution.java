package net.pack.tasksnleet.sortpowarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortedSquares(new int[]{-4,-1,0,3,10})));
    }

    public int[] sortedSquares(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        for(Integer i : nums) {
            i = Double.valueOf(Math.pow(i, 2)).intValue();
            sorted.add(i);
        }
        Collections.sort(sorted);
        for(int i = 0; i < nums.length; i++){
            nums[i] = sorted.get(i);
        }
        return nums;
    }
}
