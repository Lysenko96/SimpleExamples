package net.pack.leetcodestyle.sumoddevengcd;

import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.gcdOfOddEvenSums(4));
        System.out.println(s.gcdOfOddEvenSums(5));
    }

    public int gcdOfOddEvenSums(int n) {
        int i = 0;
        int oddCounter = 0;
        int evenCounter = 0;
        BigInteger sumOdd = BigInteger.ZERO;
        BigInteger sumEven = BigInteger.ZERO;
        while (true) {
            i++;
            if (i % 2 == 0) {
                evenCounter++;
                sumEven = sumEven.add(BigInteger.valueOf(i));
//                System.out.println("even: " + i);
                if (evenCounter == n && oddCounter == n) {
                    break;
                }
            } else {
                oddCounter++;
                sumOdd = sumOdd.add(BigInteger.valueOf(i));
//                System.out.println("odd: " +    i);
                if (oddCounter == n && evenCounter == n) {
                    break;
                }
            }
        }
//        System.out.println(sumOdd);
//        System.out.println(sumEven);
        return sumOdd.gcd(sumEven).intValue();
    }
}
