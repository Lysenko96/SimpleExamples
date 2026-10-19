package net.pack.leetcodestyle.base7;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToBase7(-7));
    }

    public String convertToBase7(int num) {
        return Long.toString(num, 7);
    }
}
