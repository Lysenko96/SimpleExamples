package net.pack.cellrange;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().cellsInRange("W5:W8"));
    }

    public List<String> cellsInRange(String s) {
        String[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase(Locale.ROOT).split("");
        String[] values = s.split("");
        int max = Math.max(Integer.parseInt(values[1]), Integer.parseInt(values[4]));
        int min = Math.min(Integer.parseInt(values[1]), Integer.parseInt(values[4]));
//        System.out.println(max);
//        System.out.println(min);
        List<String> result = new ArrayList<>();

        int indexFirst = 0;
        int indexSecond = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i].equals(values[3]) && alphabet[i].equals(values[0])) {
                indexFirst = indexSecond = i;
            } else if (alphabet[i].equals(values[0])) {
                indexFirst = i;
            } else if (alphabet[i].equals(values[3])) {
                indexSecond = i;
            }
        }
//        System.out.println(values[0]);
//        System.out.println(indexFirst);
//        System.out.println(values[3]);
//        System.out.println(indexSecond);
        for (int k = indexFirst; k <= indexSecond; k++) {
            for (int j = min; j <= max; j++) {
                result.add(alphabet[k] + j);
            }
        }
       // System.out.println(result);
        return result;
    }
}
