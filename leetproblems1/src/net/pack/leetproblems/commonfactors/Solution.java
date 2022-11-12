package net.pack.leetproblems.commonfactors;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().commonFactors(25,30));
    }

    public int commonFactors(int a, int b) {
        int counter = 0;
        for(int i = 1; i <= Math.max(a,b); i++)
            if(a % i == 0 && b % i == 0)
                counter++;

        return counter;
    }
}
