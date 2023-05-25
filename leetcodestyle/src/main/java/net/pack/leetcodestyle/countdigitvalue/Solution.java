package net.pack.leetcodestyle.countdigitvalue;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().digitCount("1210"));
        System.out.println(new Solution().digitCount("030"));
    }

    public boolean digitCount(String num) {
        String[] arr = num.split("");
        Map<String, Long> map = Arrays.stream(arr).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        int counter = 0;
        //System.out.println(map);
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(String.valueOf(i))) map.put(String.valueOf(i), 0L);

            if(Long.valueOf(arr[i]).equals(map.get(String.valueOf(i)))) counter++;
        }
        return counter == arr.length;
    }
}
