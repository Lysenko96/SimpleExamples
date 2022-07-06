package fibnumber;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().fib(2));
    }

    public int fib(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        else if (n > 1)
            n = fib(n - 1) + fib(n - 2);
        return n;
    }
}
