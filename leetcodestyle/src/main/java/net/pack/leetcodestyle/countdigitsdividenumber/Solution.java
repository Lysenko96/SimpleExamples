package net.pack.leetcodestyle.countdigitsdividenumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countDigits(7));
    }

    public int countDigits(int num) {
        List<Integer> numbers = new ArrayList<>();
        int temp = num;
        int counter = 0;
        while (temp > 0){
            numbers.add(temp % 10);
            temp /= 10;
        }
        Collections.reverse(numbers);
        for(Integer n : numbers){
            if(num % n == 0) counter++;
        }
        return counter;
    }
}
