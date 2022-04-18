package net.pack.tasksnleet.elemdel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private int[] nums = new int[]{0,1,2,2,3,0,4,2};

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.nums));
        System.out.println(solution.removeElement(solution.nums, 2));
        System.out.println(Arrays.toString(solution.nums));
    }

    public int removeElement(int[] nums, int val) {
        List<Integer> numbers = new ArrayList<>();
        for(Integer n : nums){
            if(n != val) {
                numbers.add(n);
            }
        }
        int size = numbers.size();
        for(int i = numbers.size(); i < nums.length; i++){
            numbers.add(0);
        }
        for(int i = 0; i < numbers.size(); i++){
            nums[i] = numbers.get(i);
        }
        this.nums = nums;
        return size;
    }
}