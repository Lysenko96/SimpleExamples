package net.pack.leetproblems.smallevenmulti;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestEvenMultiple(5));
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public int smallestEvenMultiple(int n) {
        System.out.println(Math.abs(n * 2));
        System.out.println(gcd(n,2));
        return Math.abs(n * 2) / gcd(n, 2);
    }
}
