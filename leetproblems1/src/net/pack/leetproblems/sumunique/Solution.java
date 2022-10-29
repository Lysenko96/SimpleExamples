package net.pack.leetproblems.sumunique;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().sumOfUnique(new int[]{1,2,3,2,2,3}));
    }

    public int sumOfUnique(int[] nums){
        List<Integer> l = new ArrayList<>();
        for(Integer i : nums){
            l.add(i);
        }
        Map<Integer, Long> map = new HashMap<>();
        map = l.stream().collect(Collectors.groupingBy(x->x, Collectors.counting()));
        System.out.println(map);
        int sum = 0;
        for(Map.Entry<Integer, Long> pair : map.entrySet()){
            if(pair.getValue() == 1){
                sum += pair.getKey();
            }
        }
        return sum;
    }
}
