package net.pack.leetcodestyle.finduniquebinstr;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //System.out.println(solution.findDifferentBinaryString(new String[]{"01","10"}));
        System.out.println(solution.findDifferentBinaryString(new String[]{"111", "100", "110"}));
    }

    public String findDifferentBinaryString(String[] nums) {
        if(nums[0].equals("0")) return "1";
        if(nums[0].equals("1")) return "0";
        int value = nums[0].length();
        double max = Math.pow(value, 2);
        List<Integer> all = new ArrayList<>();
        for(int i = 0; i <= max; i++) all.add(i);
        List<Integer> numbers = Stream.of(nums)
                .map(x -> Integer.parseInt(x, 2))
                .collect(Collectors.toList());
        if(!numbers.contains(0)) numbers.add(0);
        all.removeAll(numbers);
        StringBuilder result = new StringBuilder(Integer.toString(all.get(0), 2));
        System.out.println(result.length());
        System.out.println(value);
        for(int i = result.length(); i < value; i++) result.insert(0, "0");
        return result.toString();
    }
}
