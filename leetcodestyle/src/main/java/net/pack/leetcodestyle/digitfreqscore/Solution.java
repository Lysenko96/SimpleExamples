package net.pack.leetcodestyle.digitfreqscore;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.digitFrequencyScore(122));
        System.out.println(s.digitFrequencyScore(111222));
    }

    public int digitFrequencyScore(int n) {
        Map<Integer, Long> map = Arrays.stream(String.valueOf(n).split(""))
                .collect(Collectors.groupingBy(Integer::valueOf, Collectors.counting()));
        return (int) map.entrySet().stream().mapToLong(p -> p.getKey() * p.getValue()).sum();
    }
}
