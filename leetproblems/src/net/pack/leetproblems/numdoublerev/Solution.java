package net.pack.leetproblems.numdoublerev;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isSameAfterReversals(0));
    }

    public boolean isSameAfterReversals(int num) {
        List<Integer> digits = reverse(num);
        int value = getNumber(digits);
        List<Integer> newDigits = reverse(value);
        return getNumber(newDigits) == num;
    }

    private List<Integer> reverse(int n) {
        List<Integer> digits = new ArrayList<>();
        while (n > 0) {
            digits.add(n % 10);
            n /= 10;
        }
        return digits;
    }

    private int getNumber(List<Integer> digits) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : digits) {
            sb.append(i);
        }
        if (sb.toString().equals("")) {
            return 0;
        }
        return Integer.parseInt(sb.toString());
    }
}
