package net.pack.leetcodestyle.ishappy;

public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isHappy(1111111));
    }

    public boolean isHappy(int n) {
        String number = String.valueOf(n);
        long sum = 0;
        while (true) {
            sum = 0;
            for (String digit : number.split("")) {
                sum += (int) Math.pow(Integer.parseInt(digit), 2);
            }
            number = String.valueOf(sum);
            if (sum <= 5) {
                break;
            }
        }
        return sum == 1;
    }
}
