package net.pack.tasksnleet.sortarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParityII(new int[]{4,2,5,7})));
    }

    public int[] sortArrayByParityII(int[] nums) {
        int index =0;
        int index1 = 0;
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 0){
                evens.add(nums[i]);
            } else if(nums[i] % 2 != 0) {
                odds.add(nums[i]);
            }
        }
        Collections.sort(evens, Collections.reverseOrder());
        Collections.sort(odds);
        int[] res = new int[nums.length];
        for(int i = 0; i < res.length; i++){
            if(i % 2 == 0){
                res[i] = evens.get(index);
                index++;
            } else {
                res[i] = odds.get(index1);
                index1++;
            }
        }
        return res;
    }
}
