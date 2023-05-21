package net.pack.leetcodestyle.difbtwsumanddigitsum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().differenceOfSum(new int[]{1,2,3,4}));
    }

    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum = 0;
        for(Integer number : nums) {
            sum += number;
            for(Integer digit : getDigitsByNumber(number)){
                digitSum += digit;
            }
        }
        return Math.abs(sum - digitSum);
    }

    private List<Integer> getDigitsByNumber(int number){
        int temp = number;
        List<Integer> result = new ArrayList<>();
        while (temp > 0) {
            result.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
