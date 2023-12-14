package net.pack.leetcodestyle.removeoccurrences;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.removeOccurrences("daabcbaabcbc", "abc");
        solution.removeOccurrences("axxxxyyyyb", "xy");
        solution.removeOccurrences("aabababa", "aba");
    }

    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while(sb.toString().contains(part)) sb.replace(sb.indexOf(part), (sb.indexOf(part) + part.length()), "");
        return sb.toString();
    }
}
