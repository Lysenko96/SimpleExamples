package net.pack.tasksnleet.uniquearr;

import java.util.*;

class Solution {

    private int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(solution.arr));
    }

    public int removeDuplicates(int[] nums) {
        Solution solution = new Solution();
        Set<Integer> set = new HashSet<>();
        for (Integer n : nums) {
            set.add(n);
        }
        List<Integer> numbers = new ArrayList<>(set);
        Collections.sort(numbers);
        for(int i = numbers.size(); i < nums.length; i++){
            numbers.add(0);
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = numbers.get(i);
        }
        solution.arr = nums;
        return set.size();
    }
}