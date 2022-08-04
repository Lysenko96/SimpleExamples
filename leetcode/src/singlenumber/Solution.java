package singlenumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{1,2,1,3,2,5})));
    }

    public int[] singleNumber(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i : nums)
            l.add(i);
        Map<Integer, Long> map = l.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        List<Map.Entry<Integer, Long>> entries = map.entrySet().stream().filter(e -> e.getValue() == 1).toList();
        nums = new int[entries.size()];
        int i = 0;
        for(Map.Entry<Integer, Long> e : entries){
            nums[i] = e.getKey();
            i++;
        }
        return nums;
    }

}
