package net.pack.leetcodestyle.reversewords;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("Hello World!"));
    }

    public String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String[] words = s.split(" ");
        for(String word : words) {
            char[] lettersChar = word.toCharArray();
            List<Character> letters = new ArrayList<>();
            for (Character character : lettersChar) {
                letters.add(character);
            }
            Collections.reverse(letters);
            for (Character character : letters) {
                sb.append(character);
            }
            if ( count < words.length - 1) {
                sb.append(" ");
                count++;
            }
        }
        return sb.toString();
    }
}
