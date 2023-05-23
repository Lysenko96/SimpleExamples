package net.pack.leetcodestyle.countvowel;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().vowelStrings(new String[]{"are", "amy", "u"}, 0, 2));
//        System.out.println(new Solution().vowelStrings(new String[]{"hey","aeo","mu","ooo","artro"}, 1, 4));
         System.out.println(new Solution().vowelStrings(new String[]{"ce", "ai"}, 1, 1));
         System.out.println(new Solution().vowelStrings(new String[]{"vo","j","i","s","i"}, 0, 3));
        System.out.println(new Solution().vowelStrings(new String[]{"o"}, 0, 0));
        System.out.println(new Solution().vowelStrings(new String[]{"m","qi","ae"}, 1, 1));
    }

    public int vowelStrings(String[] words, int left, int right) {
        List<String> vowels = new ArrayList<>(Arrays.asList("a", "e", "i", "o", "u"));
        int counter = 0;
        for (int i = left; i <= right; i++) {
            if (vowels.contains(words[i].split("")[0]) && vowels.contains(words[i].split("")[words[i].length() - 1])) {
                Map<String, Long> map = Stream.of(words[i].split("")).filter(vowels::contains).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
                counter++;
            }
        }
        return counter;
    }
}
