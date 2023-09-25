package net.pack.leetcodestyle.finddiff;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().findTheDifference("a", "aa"));
        System.out.println(new Solution().findTheDifference("abcd", "abcde"));
        System.out.println(new Solution().findTheDifference("", "a"));
    }

    public char findTheDifference(String s, String t) {
        if(s.isEmpty()) return t.charAt(0);
        Map<String, Long> map = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> map1 = Arrays.stream(t.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map1.entrySet().removeAll(map.entrySet());
        return map1.keySet().stream().findAny().get().charAt(0);
    }

}
