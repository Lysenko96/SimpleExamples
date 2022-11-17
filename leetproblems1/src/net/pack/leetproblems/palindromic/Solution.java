package net.pack.leetproblems.palindromic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().isStrictlyPalindromic(9));
    }

    public boolean isStrictlyPalindromic(int n) {
        List<String> allBases = new ArrayList<>();
        Set<Boolean> set = new HashSet<>();
        for (int i = 2; i <= n - 2; i++) {
            String baseStr = Integer.toString(n, i);
            allBases.add(baseStr);
            //System.out.println(baseStr);
        }
        for (String number : allBases) {
            int lIndex = 0;
            int rIndex = number.length() - 1;
            String[] arrTwoBase = number.split("");

            while (lIndex < rIndex) {
                set.add(arrTwoBase[lIndex].equals(arrTwoBase[rIndex]));
                lIndex++;
                rIndex--;
            }
            if (set.size() >= 2) return false;
            set.add(set.size() == 1 && new ArrayList<>(set).get(0).equals(true));
        }
        return set.size() == 1 && new ArrayList<>(set).get(0).equals(true);
    }
}
