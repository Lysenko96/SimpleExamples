package net.pack.leetcodestyle.partitionlabels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    // don't pass tests

//    public static void main(String[] args) {
//        new Solution().partitionLabels("ababcbacadefegdehijhklij");
//        // new Solution().partitionLabels("eccbbbbdec");
//    }
//
//
//
//    // if 4 or less unique letter return one number ?
//    // if 5 and more split 3 + 1, and other ?
//
//    public List<Integer> partitionLabels(String s) {
//        String[] letters = s.split("");
//        int counter = 0;
//        int counterContains = 0;
//        List<Integer> result = new ArrayList<>();
//        Set<String> containsLetter = new HashSet<>();
//        for (int i = 0; i < letters.length; i++) {
//            counter++;
//            if(containsLetter.contains(letters[0]) && !containsLetter.contains(letters[i])){
//                counterContains++;
//            } else {
//                counterContains = 0;
//            }
//            if(counterContains == 2) {
//                result.add(counter-2);
//                counter = 2;
//                counterContains = 0;
//            }
//            containsLetter.add(letters[i]);
//        }
//        System.out.println(result);
//        return null;
//    }
}
