package net.pack.leetcodestyle.isomorphic;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("egg", "a12"));
        System.out.println(s.isIsomorphic("paper", "title"));
        System.out.println(s.isIsomorphic("bbbaaaba", "aaabbbba"));
    }

    public boolean isIsomorphic(String s, String t) {
        String[] arrS = s.split("");
        String[] arrT = t.split("");
        String[] res = new String[arrS.length];
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < arrS.length; i++) {
            if (!map.containsKey(arrS[i]) && !map.containsValue(arrT[i])) {
                map.put(arrS[i], arrT[i]);
            }
        }
        for (int i = 0; i < arrS.length; i++) {
            res[i] = map.get(arrS[i]);
        }
        return String.join("", res).equals(t);
    }

}
