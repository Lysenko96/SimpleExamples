package net.pack.leetcodestyle.validpalindrome;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        String update = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int right = update.length() - 1;
        String[] arr = update.split("");
        while (left < right) {
            if (!arr[left].equals(arr[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
