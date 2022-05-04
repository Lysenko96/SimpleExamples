//package net.pack.tasksnleet.maxscore;
//
//import java.util.*;
//
//public class Solution {
//
//    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().maxScoreWords(new String[]{"leet", "dog", "cat", "dad", "good"}, new char[]{'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'}, new int[]{1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
//    }
//
//    public int maxScoreWords(String[] words, char[] letters, int[] score) {
//        int count = 0;
//        int result = 0;
//        List<String> sortedList = new ArrayList<>();
//        List<Integer> scores = new ArrayList<>();
//        for (String word : words) {
//            int wordScore = 0;
//            count = 0;
//            if (word.contains("e")) {
//                for (int i = 0; i < word.split("").length; i++) {
//                    if (word.split("")[i].equals("e")) {
//                        count++;
//                    }
//                }
//            }
//            if (count > 1) {
//                scores.add(0);
//            } else {
//                sortedList.add(word);
//                Set<Character> chars = new LinkedHashSet<>();
//                for (Character ch : letters) {
//                    chars.add(ch);
//                }
//
//                Map<Character, Integer> map = new HashMap<>();
//                for (Character ch : chars) {
//                    for (int i = 0; i < alphabet.length; i++) {
//                        if (ch == alphabet[i]) {
//                            map.put(alphabet[i], score[i]);
//                        }
//                    }
//                }
//                for (String s : word.split("")) {
//
//                }
//                for (Character s : word.toCharArray()) {
//                    for (Map.Entry<Character, Integer> pair : map.entrySet()) {
//                        if (s == pair.getKey()) {
//                            wordScore += pair.getValue();
//                        }
//                    }
//                }
//                System.out.println(word);
//                System.out.println(wordScore);
//                scores.add(1);
//            }
//        }
//        System.out.println(scores);
//        System.out.println(sortedList);
//        return 0;
//    }
//}
