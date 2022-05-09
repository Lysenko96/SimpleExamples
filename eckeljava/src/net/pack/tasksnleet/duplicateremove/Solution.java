package net.pack.tasksnleet.duplicateremove;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.print(new Solution().removeDuplicates("abbbabaaa"));
    }

    public String removeDuplicates(String s) {
        String[] arr = s.split("");
        List<String> l = new ArrayList<>(Arrays.asList(arr));
        List<String> unique = new ArrayList<>(new HashSet<>(Arrays.asList(arr)));
        String result = "";
        if (unique.size() == 1 && arr.length % 2 == 0) {
            result = "";
        } else if (unique.size() == 1 && arr.length % 2 != 0) {
            result = unique.get(0);
        } else {
            while (true) {
//                System.out.println(l.size());
//                System.out.println(new HashSet<>(l).size());

                if (l.size() == new HashSet<>(l).size()) {
                    break;
                }
                l = remove(l);
            }
            StringBuilder sb = new StringBuilder();
            for (String w : l) {
                sb.append(w);
            }
            result = sb.toString();
        }
        return result;
    }

    private List<String> remove(List<String> l) {
      //  System.out.println(l);
        Set<Integer> indexes = new HashSet<>();
        int count = 0;
        for (int i = 0; i < l.size() - 1; i++) {
            if (l.get(i).equals(l.get(i + 1))) {
//                System.out.println(i);
//                System.out.println(l.get(i));
//                System.out.println(i + 1);
//                System.out.println(l.get(i + 1));
                indexes.add(i);
              //  indexes.add(i + 1);
                count++;
            } else {
                count = 0;
            }
        }
       // System.out.println(l);
       // System.out.println(indexes);
        List<Integer> setL = new ArrayList(indexes);
      //  System.out.println(setL);
        for (int i = 0; i < setL.size(); i++) {
            l.set(setL.get(i), "");
        }
      //  System.out.println(l);
        l = l.stream().filter(s1 -> !s1.equals("")).collect(Collectors.toList());
        System.out.println(l);
        return l;
    }
}
