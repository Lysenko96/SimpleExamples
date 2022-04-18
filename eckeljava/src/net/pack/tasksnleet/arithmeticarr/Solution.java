package net.pack.tasksnleet.arithmeticarr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().checkArithmeticSubarrays(new int[]{4, 6, 5, 9, 3, 7}, new int[]{0, 0, 2}, new int[]{2, 3, 5}));
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();
        for (int j = 0; j < l.length; j++) {
            List<Integer> numbers = new ArrayList<>();
            List<Boolean> booleans = new ArrayList<>();
            for (int i = l[j]; i <= r[j]; i++) {
                numbers.add(nums[i]);
            }
            Collections.sort(numbers);
           // System.out.println(numbers);
            int diff = numbers.get(1) - numbers.get(0);
            for(int i = 0; i < numbers.size()-1; i++){
                if(numbers.get(i + 1) - numbers.get(i) == diff){
                    booleans.add(true);
                }
            }
            if(numbers.get(numbers.size()-1) - numbers.get(numbers.size()-2) == diff){
                booleans.add(true);
            }
            //System.out.println(booleans);
            if(numbers.size() == booleans.size()){
                result.add(true);
            } else {
                result.add(false);
            }
        }
       // System.out.println(result);
        return result;
    }
}
