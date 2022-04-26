package net.pack.tasksnleet.mergestr;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().mergeAlternately("abs", "cdt1421"));
    }

    public String mergeAlternately(String word1, String word2) {
        String[] str1 = word1.split("");
        String[] str2 = word2.split("");
        List<String> lStr = new ArrayList<>();
        int min = Math.min(str1.length, str2.length);
        int max = Math.max(str1.length, str2.length);
        for(int i = 0; i < min; i++){
            lStr.add(str1[i]);
            lStr.add(str2[i]);
        }
        if(str1.length > str2.length){
            for(int i = min; i < max; i++){
                lStr.add(str1[i]);
            }
        } else {
            for(int i = min; i < max; i++){
                lStr.add(str2[i]);
            }
        }
       // System.out.println(lStr);
        StringBuilder s = new StringBuilder();
        for(String w : lStr){
            s.append(w);
        }
        return s.toString();
    }
}
