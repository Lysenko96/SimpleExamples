package net.pack.leetproblems.guessnumber;

public class Solution extends GuessGame {

    public static void main(String[] args) {
        new Solution().guessNumber(10);
    }


    public int guessNumber(int n) {
        int result = 0;
        while (true) {
            result = guess(n);
            if (result == 0) {
                System.out.println(n);
                break;
            }
            if (result == -1) {
                System.out.println(n);
                n += 1;
            }
             else if (result == 1) {
                System.out.println(n);
                n -= 1;
            }
        }
        return result;
    }
}

class GuessGame {

    private int z = 6;

    int guess(int num) {
        int result = 0;
        if (num > z)
            result = 1;
        if (num < z)
            result = -1;
        return result;
    }
}
