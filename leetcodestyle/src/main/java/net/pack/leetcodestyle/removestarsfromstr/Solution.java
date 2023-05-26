package net.pack.leetcodestyle.removestarsfromstr;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().removeStars("abc***das**z*z*z"));
        //System.out.println(new Solution().removeStars("abcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxabcdefghijklmnopqrstuvwxz*z*z*z*"));
    }

    public String removeStars(String s) {
        List<String> l = new ArrayList<>(Arrays.asList(s.split("")));
        ListIterator<String> it = l.listIterator();
        while (it.hasNext()) {
            String result = it.next();
            if (result.equals("*")) {
                it.remove();
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            }
        }
        // System.out.println(l);
         return String.join("", l);
    }
}
