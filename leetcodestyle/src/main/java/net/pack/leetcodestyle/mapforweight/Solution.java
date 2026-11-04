package net.pack.leetcodestyle.mapforweight;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        s.mapWordWeights(new String[]{"abcd"}, new int[]{7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5});
        s.mapWordWeights(new String[]{"abcd", "def", "xyz"}, new int[]{5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2});
    }

    public String mapWordWeights(String[] words, int[] weights) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> result = new HashMap<>();
        int i = 0;
        int j = 25;
        StringBuilder resultWord = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.put(String.valueOf(ch), weights[i]);
            result.put(j, String.valueOf(ch));
            i++;
            j--;
        }
        for (String word : words) {
            int sum = 0;
            for (String letter : word.split("")) {
                sum += map.get(letter);
//                System.out.println(sum);
            }
//            System.out.println(sum % 26);
//            System.out.println(result.get(sum % 26));
                resultWord.append(result.get(sum % 26));
            }
//        System.out.println(result);
//        System.out.println(map);
//        System.out.println(resultWord);
            return resultWord.toString();

        }
    }
