package net.pack.leetcodestyle.summultiples;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().sumOfMultiples(10));
    }

    public int sumOfMultiples(int n) {
        int sum = 0;
        for(int i = 0; i <= n; i++){
            if(i % 3 == 0 || i % 5 == 0 || i % 7 == 0) sum += i;
        }
        return sum;
    }
}
