package net.pack.leetcodestyle.mettarget;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfEmployeesWhoMetTarget(new int[]{0,1,2,3,4}, 2));
        System.out.println(new Solution().numberOfEmployeesWhoMetTarget(new int[]{5,1,4,2,2}, 6));
    }

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        return (int) Arrays.stream(hours).filter(hour -> hour >= target).count();
    }
}
