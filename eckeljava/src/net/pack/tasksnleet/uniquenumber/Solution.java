package net.pack.tasksnleet.uniquenumber;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
      //  System.out.println(new Solution().uniqueOccurrences(new int[]{1, 2}));

    }

    public boolean uniqueOccurrences(int[] arr) {
        List<Integer> arrList = new ArrayList<>();
        for(Integer i : arr){
            arrList.add(i);
        }
        Map<Integer, Long> map = arrList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
        int sum = 0;
        List<Long> l = new ArrayList<>();
        Set<Long> s = new HashSet<>();
        for(Map.Entry<Integer,Long> pair : map.entrySet()){
            sum += pair.getValue();
            l.add(pair.getValue());
            s.add(pair.getValue());
        }
        return l.size() == s.size();
    }
}
