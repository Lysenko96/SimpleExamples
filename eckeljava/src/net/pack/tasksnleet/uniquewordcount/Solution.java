package net.pack.tasksnleet.uniquewordcount;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countWords(new String[]{"a","ab"}, new String[]{"a","a","a","ab"}));
    }

    public int countWords(String[] words1, String[] words2) {
        Map<String, Long> map1 = Arrays.stream(words1).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> map2 = Arrays.stream(words2).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<String, Long>> list1 = map1.entrySet().stream().filter(m -> m.getValue() == 1).collect(Collectors.toList());
        List<Map.Entry<String, Long>> list2 = map2.entrySet().stream().filter(m -> m.getValue() == 1).collect(Collectors.toList());
        int count = 0;
        for(Map.Entry<String, Long> pair : list1){
            for(Map.Entry<String, Long> pair2 : list2){
                if(pair.equals(pair2)){
                    count++;
                }
            }
        }
        return count;
    }
}
