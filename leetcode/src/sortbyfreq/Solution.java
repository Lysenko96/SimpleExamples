package sortbyfreq;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;


public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().frequencySort(new int[]{-1, 1, -6, 4, 5, -6, 1, 4, 1})));
    }

    public int[] frequencySort(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : nums)
            list.add(i);

        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        //System.out.println(map);
        List<Map.Entry<Integer, Long>> entries = map.entrySet().stream().sorted(Map.Entry.<Integer, Long>comparingByKey().reversed()).sorted(comparingByValue()).toList();
        //System.out.println(entries);
        List<Integer> numsList = new ArrayList<>();
        for(Map.Entry<Integer, Long> pair : entries){
            for(int i = 0; i < pair.getValue(); i++) {
                numsList.add(pair.getKey());
            }
        }
        //System.out.println(numsList);
        nums = new int[numsList.size()];

        for(int i = 0; i < numsList.size(); i++)
            nums[i] = numsList.get(i);

        return nums;
    }
}
