package net.pack.tasksnleet.countprefix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countPrefixes(new String[]{"a","a"}, "aa"));
       // System.out.println(new Solution().countPrefixes(new String[]{"a","b","c","ab","bc","abc"}, "abc"));
    }

    public int countPrefixes(String[] words, String s) {
        List<String> prefixes = new ArrayList<>();
        String[] arrS = s.split("");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arrS.length; i++){
            sb.append(arrS[i]);
            System.out.println(sb);
            prefixes.add(sb.toString());
        }
        List<String> res = new ArrayList<>();
        for(String w : words){
            for(String p : prefixes) {
                if (w.equals(p)){
                    res.add(p);
                }
            }
        }
//        System.out.println(res);
//        System.out.println(new HashSet<>(res));
        return res.size();
    }
}
