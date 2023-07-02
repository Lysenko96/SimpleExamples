package net.pack.leetcodestyle.plusone;

import java.math.BigDecimal;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{19,8,7,6,5,4,3,2,1,0})));
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6})));

    }
    public int[] plusOne(int[] digits) {
        StringBuilder sbNumber = new StringBuilder();
        for(int n : digits) {
            sbNumber.append(n);
        }
        BigDecimal val = new BigDecimal(sbNumber.toString());
        BigDecimal valPlus = val.add(BigDecimal.ONE);
        String[] strValArr = String.valueOf(valPlus).split("");
        if(strValArr.length > digits.length){
            digits = new int[digits.length + 1];
        }
        for(int i = 0; i < strValArr.length; i++){
            digits[i] = Integer.parseInt(strValArr[i]);
        }
        return digits;
    }
}
