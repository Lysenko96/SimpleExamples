package net.pack.leetcodestyle.reveresestrprefix;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reversePrefix("abcd", 2);
    }

    public String reversePrefix(String s, int k) {
        StringBuilder str = new StringBuilder(s);
        StringBuilder reverse = new StringBuilder(str.substring(0, k)).reverse();
        reverse.append(str.substring(k));
        return reverse.toString();
    }
}
