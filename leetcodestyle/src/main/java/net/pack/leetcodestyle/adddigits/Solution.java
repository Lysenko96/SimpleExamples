package net.pack.leetcodestyle.adddigits;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().addDigits(38));
    }

    public int addDigits(int num) {
        long length = String.valueOf(num).split("").length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += Integer.parseInt(String.valueOf(num).split("")[i]);
        }
        while (String.valueOf(sum).length() != 1) {
            sum = addDigits(sum);
        }
        return sum;
    }
}
