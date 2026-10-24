package net.pack.leetcodestyle.maxstrdistinct;

import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDistinct("abab"));
        System.out.println(solution.maxDistinct("abcd"));
        System.out.println(solution.maxDistinct("aaaa"));
    }

    public int maxDistinct(String s) {
        return new HashSet<>(List.of(s.split(""))).size();
    }
}

