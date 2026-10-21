package net.pack.leetcodestyle.ransomenote;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canConstruct("aa", "aab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<String, Long> ransom = Arrays.stream(ransomNote.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> magaz = Arrays.stream(magazine.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<String, Long> entry : ransom.entrySet()) {
            if (!magaz.containsKey(entry.getKey()) || magaz.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
