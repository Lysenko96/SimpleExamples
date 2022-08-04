package goatlatin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(new Solution().toGoatLatin("I speak Goat Latin"));
        System.out.println(new Solution().toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public String toGoatLatin(String sentence) {
        List<String> vowels = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
        List<String> words = Arrays.asList(sentence.split(" "));
        StringBuilder line = new StringBuilder();
        //System.out.println(words);
        StringBuilder res = new StringBuilder("maa");
        for (String word : words) {
            //System.out.println(word.split("")[0].toLowerCase());
            if (vowels.contains(word.split("")[0].toLowerCase())) {
                word = word + res;
            } else {
                word = word.substring(1, word.length()) + word.split("")[0];
                word = word + res;
            }
            res.append("a");
            line.append(word).append(" ");
          //  System.out.println(word);
        }
        //System.out.println(words);
        return line.toString().trim();
    }

}
