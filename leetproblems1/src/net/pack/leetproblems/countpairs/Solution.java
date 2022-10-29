package net.pack.leetproblems.countpairs;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countKDifference(new int[]{3,2,1,5,4},2));
    }

    public int countKDifference(int[] nums, int k){
        List<Integer> exp = new ArrayList<>();
        for(Integer i : nums){
            exp.add(i-k);
        }
        int count = 0;
        for(int j = 0; j < nums.length; j++){
            for(int m = 0; m < exp.size(); m++){
                if(nums[j] == exp.get(m) && j != m){
                    count++;
                }
            }
        }
        return count;
    }
}
