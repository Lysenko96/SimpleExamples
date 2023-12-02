package net.pack.leetcodestyle.sortvowels;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    private List<String> vowels = List.of("a", "e", "i", "o", "u");

    public static void main(String[] args) {
        System.out.println(new Solution().sortVowels("lEetcOde"));
    }

    public String sortVowels(String s) {
        List<String> sortedVowels = Arrays.stream(s.split("")).filter(symbol -> vowels.contains(symbol.toLowerCase())).sorted().collect(Collectors.toList());
        String[] arrStr = s.split("");
        int index = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < arrStr.length; i++){
            if(vowels.contains(arrStr[i].toLowerCase())){
                arrStr[i] = sortedVowels.get(index);
                index++;
            }
            result.append(arrStr[i]);
        }
        return result.toString();
    }
}
