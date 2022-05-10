package net.pack.tasksnleet.disttochar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().shortestToChar("loveleetcode", 'e')));
    }

    public int[] shortestToChar(String s, char c) {
        List<Integer> indexes = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        String[] letters = s.split("");
        for (int i = 0; i < letters.length; i++) {
            if (letters[i].equals(String.valueOf(c))) {
                indexes.add(0);
            } else {
                indexes.add(i + 1);
            }
        }
        System.out.println(indexes);
        // if index.get(i) != 0
        // find most near 0


//        indexes.add(letters.length);
//        System.out.println(indexes);
//        int count = 0;
//        int index = 0;
//        for (int j = 0; j < indexes.size(); j++) {
//            StringBuilder sb = new StringBuilder();
//            for (int i = index; i < indexes.get(j); i++) {
//                if (letters[i].equals(String.valueOf(c))) {
//                    res.add(0);
//                }
//                sb.append(letters[i]);
//            }
//            int length = sb.length();
//            if (sb.toString().contains(String.valueOf(c))) {
//                length = sb.length() - 1;
//            }
//            System.out.println(sb);
//            index = indexes.get(j);
//            for (int k = length; k > 0; k--) {
//                res.add(k);
//            }
//        }
//        System.out.println(res);
        return null;
    }
}
