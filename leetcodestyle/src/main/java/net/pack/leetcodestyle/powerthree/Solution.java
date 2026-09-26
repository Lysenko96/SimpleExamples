package net.pack.leetcodestyle.powerthree;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfThree(1));
    }

    public boolean isPowerOfThree(int n) {
        if (n < 0 )return false;
        if (n == 0) return false;
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
}
