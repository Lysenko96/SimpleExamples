package net.pack.leetcodestyle.reversevowels;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels("IceCreAm"));
    }

    private List<String> vowels = Arrays.asList("a", "e", "i", "o", "u");

    public String reverseVowels(String s) {
        String[] arr = s.split("");
        List<String> letters = Arrays.stream(arr)
                .filter(l -> vowels.contains(l.toLowerCase()))
                .collect(Collectors.toList());
        Collections.reverse(letters);
        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (vowels.contains(arr[j].toLowerCase())) {
                arr[j] = letters.get(i);
                i++;
            }
        }
        return String.join("", arr);
    }

}
