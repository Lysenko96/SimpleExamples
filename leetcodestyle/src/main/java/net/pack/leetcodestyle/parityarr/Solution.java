package net.pack.leetcodestyle.parityarr;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniformArray(new int[]{2, 3}));
        System.out.println(solution.uniformArray(new int[]{4, 6}));
    }

    public boolean uniformArray(int[] nums1) {
        if (Arrays.stream(nums1).allMatch(n -> n % 2 == 0)) {
            return true;
        }
        if (Arrays.stream(nums1).allMatch(n -> n % 2 != 0)) {
            return true;
        }
        int firstOdd = Arrays.stream(nums1).filter(n -> n % 2 != 0).findFirst().getAsInt();
        int[] arr = Arrays.stream(nums1).filter(n -> n % 2 == 0).map(n -> n - firstOdd).toArray();
        if (Arrays.stream(arr).allMatch(n -> n % 2 != 0)) {
            return true;
        }
        return false;
    }
}
