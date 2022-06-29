package singlenum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{1,2,2,3,1}));
    }

    public int singleNumber(int[] nums) {
        List<Integer> integerList = new ArrayList<>();
        for(Integer i : nums){
            integerList.add(i);
        }
        Map<Integer, Long> map = integerList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<Integer, Long>> filteredList = map.entrySet().stream().filter(n -> n.getValue() == 1).toList();
        //System.out.println(filteredList);
        return filteredList.get(0).getKey();
    }
}
