package net.pack.leetcodestyle.minsteptoanagram;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        new Solution().minSteps("leetcode", "practice");
        new Solution().minSteps("bab", "aba");
        new Solution().minSteps("anagram", "mangaar");
        new Solution().minSteps("gctcxyuluxjuxnsvmomavutrrfb", "qijrjrhqqjxjtprybrzpyfyqtzf");
    }

    public int minSteps(String s, String t) {
        Map<String, Long> map = Arrays.stream(s.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> map1 = Arrays.stream(t.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int counter = 0;

        for (String key : map.keySet()) {
            if (map1.containsKey(key)) {
                if (map1.get(key) - map.get(key) < 0) {
                    counter += (int) Math.abs(map1.get(key) - map.get(key));
                }
            } else {
                counter += map.get(key);
            }
        }
        return counter;
    }

}
