package net.pack.leetproblems.percentofletter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        //System.out.println(new Solution().percentageLetter("foobar", 'o'));
        //System.out.println(new Solution().percentageLetter("jjjj", 'k'));
        System.out.println(new Solution().percentageLetter("sgawtb", 's'));
        System.out.println(new Solution().percentageLetter("vmvvvvvzrvvpvdvvvvyfvdvvvvpkvvbvvkvvfkvvvkvbvvnvvomvzvvvdvvvkvvvvvvvvvlvcvilaqvvhoevvlmvhvkvtgwfvvzy", 'v'));
    }

    public int percentageLetter(String s, char letter) {
        String[] symbols = s.split("");
        List<String> list = new ArrayList<>(Arrays.asList(symbols));
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(map);
        int counter = 0;
        if (map.containsKey(String.valueOf(letter)))
            counter = map.get(String.valueOf(letter)).intValue();

        if (list.contains(String.valueOf(letter))) {
            // System.out.println((float) counter / list.size() * 100);
            if ((counter * 1f / (s.length()) * 100) >= (int) Math.floor(counter * 1f / (s.length()) * 100) + 0.99f)
                return Math.round(counter * 1f / (s.length()) * 100);

            return (int) Math.floor(counter * 1f / (s.length()) * 100);
        }

        return counter;
    }
}
