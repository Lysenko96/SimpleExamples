package net.pack.leetcodestyle.wordpattern;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordPattern("abba", "dog cat cat dog"));
        System.out.println(s.wordPattern("abba", "dog cat cat fish"));
        System.out.println(s.wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String s) {
        String[] arrPattern = pattern.split("");
        List<String> wordPattern = Arrays.stream(pattern.split("")).distinct().collect(Collectors.toList());
        List<String> words = Arrays.stream(s.split(" ")).distinct().collect(Collectors.toList());
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if (wordPattern.size() != words.size()) {
            return false;
        }
        for (int i = 0; i < wordPattern.size(); i++) {
            map.put(wordPattern.get(i), words.get(i));
        }
        for (String string : arrPattern) {
            sb.append(map.get(string)).append(" ");
        }
        return sb.toString().trim().equals(s);
    }

}
