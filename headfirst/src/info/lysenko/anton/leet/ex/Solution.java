package info.lysenko.anton.leet.ex;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findMiddleIndex(new int[]{2,3,-1,8,4}));
        System.out.println(new Solution().findMiddleIndex(new int[]{2,5}));
    }

    public int findMiddleIndex(int[] nums) {
        int sumLeft = 0;
        int sumAll = 0;
        int sumRight = 0;
        int prev = 0;

        for (int num : nums) sumAll += num;

        for(int i = 0; i < nums.length; i++){
            prev = sumLeft;
            sumLeft += nums[i];
            sumRight = sumAll - sumLeft;
            if(prev == sumRight)
                return i;

        }
        return -1;
    }
}
