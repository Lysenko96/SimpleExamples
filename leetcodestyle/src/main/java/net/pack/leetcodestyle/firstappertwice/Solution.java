package net.pack.leetcodestyle.firstappertwice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedCharacter("abcbcaacz"));
    }

    public char repeatedCharacter(String s) {
        String[] arr = s.split("");
        Map<Character, Long> map = new HashMap<>();
        Character result = null;
        for(String letter : arr){
            if(!map.containsKey(letter.charAt(0))){
                map.put(letter.charAt(0), 1L);
            } else {
                map.computeIfPresent(letter.charAt(0), Long::sum);
                if(map.get(letter.charAt(0)) >= 2) {
                    result = letter.charAt(0);
                    break;
                }
            }
        }
        return result;
    }
}
