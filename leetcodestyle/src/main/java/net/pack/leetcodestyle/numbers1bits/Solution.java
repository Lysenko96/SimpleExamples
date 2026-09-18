package net.pack.leetcodestyle.numbers1bits;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(11));
    }

    public int hammingWeight(int n) {
        return (int) Arrays.stream(Integer.toBinaryString(n).split(""))
                .filter(x -> x.equals("1"))
                .count();
    }
}
