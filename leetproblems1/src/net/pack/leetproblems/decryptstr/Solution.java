package net.pack.leetproblems.decryptstr;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().freqAlphabets("1326#125#4"));
    }

    public String freqAlphabets(String s) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        String[] res = s.split("");
        List<String> resL = Arrays.asList(res);
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < resL.size(); i++) {
            if (resL.get(i).equals("#")) {
                indexes.add(i);
            }
        }
        List<String> tagLetter = new ArrayList<>();
        for (Integer n : indexes) {
            for (int i = 0; i < s.length(); i++) {
                if (i == n) {
                    tagLetter.add(s.substring(i - 2, i));
                }
            }
        }
        int k = 0;
        List<Integer> newIndexes = new ArrayList<>();
        for (Integer n : indexes) {
            for (int i = 0; i < resL.size(); i++) {
                if (i == n - 2) {
                    resL.set(i, tagLetter.get(k));
                    k++;
                    newIndexes.add(i);
                }
            }
        }
        List<Integer> delId = new ArrayList<>();
        for(Integer id : newIndexes) {
            delId.add(id + 1);
            delId.add(id + 2);
        }
        List<String> copyResL = new ArrayList<>(resL);
        for(Integer dId : delId) {
            for (int i = 0; i < resL.size(); i++) {
                if (i == dId) {
                    copyResL.set(i,null);
                }
            }
        }
        copyResL.removeIf(Objects::isNull);
        StringBuilder sb = new StringBuilder();
        for(String w : copyResL){
            sb.append(alphabet[new Integer(w)-1]);
        }
        return sb.toString();
    }
}