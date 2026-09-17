package net.pack.leetcodestyle.reversebit;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseBits(43261596);
    }

    public int reverseBits(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder reverse = new StringBuilder(binary);
        reverse.reverse();
        while (reverse.length() < 32) {
            reverse.append("0");
        }
        return Integer.parseInt(reverse.toString(), 2);
    }
}
