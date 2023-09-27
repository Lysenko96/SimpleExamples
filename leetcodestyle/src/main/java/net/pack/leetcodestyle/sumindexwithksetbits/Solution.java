package net.pack.leetcodestyle.sumindexwithksetbits;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().sumIndicesWithKSetBits(Arrays.asList(5,10,1,5,2), 1));
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for(int i = 0; i < nums.size(); i++){
            String binary = Integer.toString(i, 2);
            int bitCounter = (int) Arrays.stream(binary.split("")).filter(bit -> bit.equals("1")).count();
            if(bitCounter == k) sum += nums.get(i);
        }
        return sum;
    }
}
