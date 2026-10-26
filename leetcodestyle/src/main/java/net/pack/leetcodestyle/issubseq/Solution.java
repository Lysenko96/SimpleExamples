package net.pack.leetcodestyle.issubseq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubsequence("aace", "abgaklczxce"));
        System.out.println(s.isSubsequence("aza", "aabzzba"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
        System.out.println(s.isSubsequence("acb", "ahbgdc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        List<String> seq = Arrays.asList(t.split(""));
        List<String> sub = Arrays.asList(s.split(""));
        List<String> subDuplicate = new ArrayList<>();
        for (String string : seq) {
            if (sub.contains(string)) {
                subDuplicate.add(string);
            }
        }
        System.out.println(subDuplicate);
        System.out.println(sub);
        Map<String, String> m;
        return false;
    }
}
