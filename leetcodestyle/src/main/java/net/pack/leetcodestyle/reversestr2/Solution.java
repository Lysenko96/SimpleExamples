package net.pack.leetcodestyle.reversestr2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseStr("abcd", 2));
        System.out.println(s.reverseStr("abcdefg", 2));
    }

    public String reverseStr(String s, int k) {
        String[] arr = s.split("");
        String str = "";
        List<String> flip = new ArrayList<>();
        for (int i = 0; i < arr.length; i = i + k) {
            if (i + k > arr.length) {
                str = s.substring(i, arr.length);
            } else {
                str = s.substring(i, i + k);
            }
            flip.add(str);
        }
        List<String> reversed = new ArrayList<>();
        for (int i = 0; i < flip.size(); i++) {
            if (i % 2 == 0) {
                reversed.add(i, new StringBuilder(flip.get(i)).reverse().toString());
            } else {
                reversed.add(i, flip.get(i));
            }
        }
        return String.join("", reversed);
    }
}
