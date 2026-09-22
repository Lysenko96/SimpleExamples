package net.pack.leetcodestyle.validanagram;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isAnagram("anagram","nagaram"));
        System.out.println(s.isAnagram("rat","car"));
    }

    public boolean isAnagram(String s, String t) {
        Map<String, Long> mapS = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> mapT = Arrays.stream(t.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return mapS.equals(mapT);
    }
}
