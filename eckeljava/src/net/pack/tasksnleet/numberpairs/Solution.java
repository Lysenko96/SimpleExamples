package net.pack.tasksnleet.numberpairs;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numOfPairs(new String[]{"1","1","1"},"11"));
    }

    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            for (int j = 0; j < nums.length; j++){
                if(i != j && (nums[i] + nums[j]).equals(target)){
                    count++;
                }
            }
        }
        return count;
    }
}
