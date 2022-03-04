package net.pack.algo;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countOperations(2, 3));
    }

    public int countOperations(int num1, int num2) {
        Step step = new Step(num1, num2);
        int count = 0;
        while (true) {
            if (step.n1 == 0 || step.n2 == 0) {
                break;
            }
            step = check(step.n1, step.n2);
            count++;
        }
        return count;
    }

    private Step check(int num1, int num2) {
        Step step = null;
        if (num1 == num2) {
            num1 -= num2;
            step = new Step(num1, num2);
        } else if (num1 >= num2) {
            num1 -= num2;
            step = new Step(num1, num2);
        } else {
            num2 -= num1;
            step = new Step(num1, num2);
        }
        return step;
    }

    class Step {

        int n1;
        int n2;

        public Step(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }

        @Override
        public String toString() {
            return "Step{" +
                    "n1=" + n1 +
                    ", n2=" + n2 +
                    '}';
        }
    }
}
