package net.pack.leetproblems.countsubstract;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countOperations(5, 4));
    }

    public int countOperations(int num1, int num2) {
        int counter = 0;
        while (true) {
            if (num1 == 0 || num2 == 0) break;
            if (num1 >= num2) {
                num1 -= num2;
                //System.out.println("num1 : " + num1);
            } else if (num2 >= num1) {
                num2 -= num1;
               // System.out.println("num2 : " + num2);
            }
            counter++;
        }
        return counter;
    }
}
