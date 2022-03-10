package net.pack.rearangearr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().rearrangeArray(new int[]{3,1,-2,-5,2,-4})));
    }

    public int[] rearrangeArray(int[] nums) {
        List<Integer> positives = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();
        for(Integer n : nums){
            if(n >= 0){
                positives.add(n);
            } else {
                negatives.add(n);
            }
        }
        int[] res = new int[nums.length];
        int countP = 0;
        int countN = 0;
        for(int i = 0; i < res.length; i++){
            if(i % 2 == 0){
                res[i] = positives.get(countP);
                countP++;
            } else {
                res[i] = negatives.get(countN);
                countN++;
            }
        }
        return res;
    }
}
