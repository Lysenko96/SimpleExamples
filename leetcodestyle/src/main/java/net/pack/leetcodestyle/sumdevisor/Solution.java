package net.pack.leetcodestyle.sumdevisor;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkPerfectNumber(28));
        System.out.println(s.checkPerfectNumber(7));
    }

    public boolean checkPerfectNumber(int num) {
        int res = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                res += i;
            }
        }
        return res == num;
    }
}
