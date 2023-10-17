package net.pack.leetcodestyle.minmaxpairsumarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPairSum(new int[]{2,3,5,3}));
        System.out.println(solution.minPairSum(new int[]{3,5,4,2,4,6}));
    }

    public int minPairSum(int[] nums) {
        List<Integer> sorted = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        int rightIndex = nums.length-1;
        int leftIndex = 0;
        List<Integer> pairSums = new ArrayList<>();
        while (leftIndex < rightIndex){
            pairSums.add(sorted.get(leftIndex) + sorted.get(rightIndex));
            leftIndex++;
            rightIndex--;
        }
        //System.out.println(pairSums);
        return pairSums.stream().sorted().collect(Collectors.toList()).get(pairSums.size()-1);
    }
}
