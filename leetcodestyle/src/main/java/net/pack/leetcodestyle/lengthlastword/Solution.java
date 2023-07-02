package net.pack.leetcodestyle.lengthlastword;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("Hello World"));
        System.out.println(new Solution().lengthOfLastWord("   fly me   to   the moon  "));
    }
    public int lengthOfLastWord(String s) {
        return s.trim().split(" ")[s.trim().split(" ").length-1].length();
    }
}