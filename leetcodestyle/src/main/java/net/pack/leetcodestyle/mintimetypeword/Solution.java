package net.pack.leetcodestyle.mintimetypeword;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        System.out.println(new Solution().minTimeToType("bza"));
//        System.out.println(new Solution().minTimeToType("zjpc"));
//       System.out.println(new Solution().minTimeToType("abc"));
//        System.out.println(new Solution().minTimeToType("pdy"));
    }


    public int minTimeToType(String word) {
        return 0;
    }


  //  public int minTimeToType(String word) {
//        List<String> alphabet = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
//        List<String> alphabet2 = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
//        List<String> reverseAlphabet = new ArrayList<>(Arrays.asList("abcdefghijklmnopqrstuvwxyz".split("")));
//        ListIterator<String> it = alphabet.listIterator();
//        ListIterator<String> it2 = alphabet2.listIterator();
//        List<Integer> seconds = new ArrayList<>();
//        it2.next();
//        int nextCounter = 0;
//        int prevCounter = 0;
//        int index = 0;
//        int counter = 1;
//        for (String letter : word.split("")) {
//            alphabet.addAll(0, reverseAlphabet);
//            counter++;
//            if (letter.equals("a") && word.split("")[0].equals("a")) {
//                seconds.add(0);
//                continue;
//            }
//            List<Integer> pair = new ArrayList<>();
//
//            it = alphabet.listIterator();
//            for (int i = 0; i < 26 * counter - index; i++) {
//                if (it.hasNext()) it.next();
//            }
//
//            while (it.hasPrevious()) {
//                prevCounter++;
//                if (it.previous().equals(letter)) {
//                    //System.out.println(prevCounter);
//                    pair.add(prevCounter);
//                    index += prevCounter;
//                    prevCounter = 0;
//                    break;
//                }
//            }
//
//            if (!it2.hasNext()) {
//                alphabet2.addAll(new ArrayList<>(alphabet2));
//                it2 = alphabet2.listIterator();
//            }
//
//            while (it2.hasNext()) {
//                nextCounter++;
//                if (it2.next().equals(letter)) {
//                    //System.out.println(nextCounter);
//                    pair.add(nextCounter);
//                    nextCounter = 0;
//                    break;
//                }
//            }
//            seconds.add(Collections.min(pair));
//        }
//        int sum = 0;
//        for (Integer sec : seconds) sum += sec;
//        return sum + word.length();
//    }
}
