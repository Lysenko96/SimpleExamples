package net.pack.leetproblems.prefix;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestCommonPrefix(new String[]{"a"}));
    }

    public String longestCommonPrefix(String[] strs) {
        String str = strs[0];
        int begin = 0;
        int end = strs[0].length();
        Set<String> prefixes = new HashSet<>();
        if(strs.length == 1){
            return strs[0];
        }
        while (begin < end) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].startsWith(str.substring(0, begin + 1))) {
                    prefixes.add(str.substring(0, begin + 1));
                  //  System.out.println(str.substring(0, begin + 1));
                } else {
                    prefixes.add("");
                }
            }
            begin++;
        }
        System.out.println(prefixes);
        if(prefixes.isEmpty()){
            prefixes.add("");
        }
        List<String> filterPref = new ArrayList<>();
        for (String p : prefixes) {
            int value = 0;
            for (String s : strs) {
                if (s.startsWith(p)) {
                    value++;
                }
            }
            //System.out.println(value);
            if(strs.length == value){
                filterPref.add(p);
            }
        }
       // System.out.println(filterPref);
        Collections.sort(filterPref);
       // System.out.println(filterPref);
        return filterPref.get(filterPref.size()-1);
    }
}