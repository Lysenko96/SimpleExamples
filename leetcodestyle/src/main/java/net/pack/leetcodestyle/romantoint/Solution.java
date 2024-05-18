package net.pack.leetcodestyle.romantoint;

import java.util.HashMap;

public class Solution {

    private static HashMap<String, Integer> map = new HashMap() {{
        put("I", 1);
        put("V", 5);
        put("X", 10);
        put("L", 50);
        put("C", 100);
        put("D", 500);
        put("M", 1000);
    }};

    public static void main(String[] args) {
        System.out.println(map);
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }
    public int romanToInt(String s) {
        String[] arr = s.split("");
        int result = 0;
        int temp = 0;
        temp = map.get(arr[arr.length - 1]);
        for(int i = arr.length - 1; i >= 0; i--) {
            if(temp <= map.get(arr[i])) result += map.get(arr[i]);
            else result -= map.get(arr[i]);
            temp = map.get(arr[i]);
        }
        return result;
    }
}
