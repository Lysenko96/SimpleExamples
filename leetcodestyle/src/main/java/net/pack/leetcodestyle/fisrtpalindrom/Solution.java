package net.pack.leetcodestyle.fisrtpalindrom;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().firstPalindrome(new String[]{"abc", "ara"}));
    }

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            int firstIndex = 0;
            int lastIndex = word.length() - 1;
            char[] letters = word.toCharArray();
            int count = 0;
            while (firstIndex < lastIndex) {
                if (letters[firstIndex] == letters[lastIndex]) {
                    count += 2;
                }
                firstIndex++;
                lastIndex--;
            }
            int len = word.length();
            if ((len % 2 == 0 && count == len) || (len % 2 != 0 && count == (len - 1))){
                return word;
            }
        }
        return "";
    }
}
