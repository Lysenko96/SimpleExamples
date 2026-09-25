package net.pack.leetcodestyle.numberbinflip;

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findComplement(5));
    }

    public int findComplement(int num) {
        String bin = Integer.toBinaryString(num);
        StringBuilder newBin = new StringBuilder();
        for (String s : bin.split("")) {
            if (s.equals("0")) {
                newBin.append("1");
            } else {
                newBin.append("0");
            }
        }
        return Integer.parseInt(newBin.toString(), 2);
    }
}
