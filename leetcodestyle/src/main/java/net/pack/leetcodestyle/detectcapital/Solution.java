package net.pack.leetcodestyle.detectcapital;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.detectCapitalUse("Google"));
        System.out.println(s.detectCapitalUse("USA"));
        System.out.println(s.detectCapitalUse("leet"));
        System.out.println(s.detectCapitalUse("LeeT"));
        System.out.println(s.detectCapitalUse("leeT"));
    }

    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) {
            return true;
        }
        if (word.equals(word.toLowerCase())) {
            return true;
        }
        return word.split("")[0].equals(word.split("")[0].toUpperCase()) &&
                word.substring(1).equals(word.substring(1).toLowerCase());
    }
}
