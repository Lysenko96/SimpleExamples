package net.pack.leetproblems.converting;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().sumBase(34,6));
    }

    public int sumBase(int n, int k){
        String res = Integer.toString(Integer.parseInt(String.valueOf(n), 10),k);
        String[] strDigits = res.split("");
        int sum = 0;
        for(String strDigit : strDigits){
            sum += Integer.parseInt(strDigit);
        }
        return sum;
    }
}