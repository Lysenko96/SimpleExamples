package net.pack.leetcodestyle.firstunique;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("aabb"));
        System.out.println(s.firstUniqChar("leet"));
    }

    public int firstUniqChar(String s) {
        String[] arr = s.split("");
        Map<String, Long> map = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == 1) {
                return i;
            }
        }
        return -1;
    }
}
