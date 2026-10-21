package net.pack.leetcodestyle.powerfour;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPowerOfFour(16));
        System.out.println(s.isPowerOfFour(5));
        System.out.println(s.isPowerOfFour(64));
    }

    public boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        List<Integer> powFour = new ArrayList<>();
        long t = 4;
        while (true) {
            powFour.add((int) t);
            t *= 4;
            if (t > Integer.MAX_VALUE) {
                break;
            }
        }return powFour.contains(n);
    }

}
