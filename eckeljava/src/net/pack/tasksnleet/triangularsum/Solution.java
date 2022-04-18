package net.pack.tasksnleet.triangularsum;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().triangularSum(new int[]{1,2,3}));
    }

    public int triangularSum(int[] nums) {
        int result = 0;
        if(nums.length == 1){
            result = nums[0];
        } else if (nums.length == 2) {
            int[] arr = getSumLine(nums);
          //  System.out.println(Arrays.toString(arr));
            result = arr[0];
        } else if (nums.length >= 3){
            int[] arr = getSumLine(nums);
         //   System.out.println(Arrays.toString(arr));
            for (int i = 0; i < nums.length - 1; i++) {
                arr = getSumLine(arr);
          //      System.out.println(Arrays.toString(arr));
                if (arr.length == 1) {
                    result = arr[0];
                }
            }
        }
        return result;
    }

    public int[] getSumLine(int[] nums) {
        int[] arr = new int[nums.length - 1];
        for (int i = 0; i < arr.length; i++) {
            //System.out.println((nums[i] + nums[i + 1]) % 10);
            arr[i] = (nums[i] + nums[i + 1]) % 10;
        }
        return arr;
    }
}
