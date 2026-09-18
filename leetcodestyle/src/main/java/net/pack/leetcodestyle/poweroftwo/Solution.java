package net.pack.leetcodestyle.poweroftwo;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPowerOfTwo(1);
    }

    public boolean isPowerOfTwo(int n) {
        return n > 0 && n == Integer.highestOneBit(n);
    }
}
