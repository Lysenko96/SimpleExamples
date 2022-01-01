package net.pack.leetcodestyle.indexsorted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().targetIndices(new int[]{1,2,5,2,3}, 4));
    }

    public List<Integer> targetIndices(int[] nums, int target){
        List<Integer> result = new ArrayList<>();
        List<Integer> numsList = new ArrayList<>();
        for(Integer i : nums){
            numsList.add(i);
        }
        Collections.sort(numsList);
        for(int i = 0; i < numsList.size(); i++){
            if(numsList.get(i) == target){
                result.add(i);
            }
        }
        return result;
    }
}
