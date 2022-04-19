package net.pack.tasksnleet.countpairs;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(new int[]{1,2,3,4}, 1));
    }

    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
           // System.out.println(nums[i]);
           // System.out.println(count);
        }
        System.out.println(count / 2);
        return count/2;
    }

}
