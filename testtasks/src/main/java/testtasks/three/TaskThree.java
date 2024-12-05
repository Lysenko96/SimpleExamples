package testtasks.three;

import java.math.BigDecimal;

public class TaskThree {

    public static void main(String[] args) {
        TaskThree taskThree = new TaskThree();
        int result = taskThree.getResult();
        System.out.println(result);
    }

    // get result
    private int getResult() {
        String[] arr = String.valueOf(getFactorial(100)).split("");
        int result = 0;
        for (String s : arr) {
            result += Integer.parseInt(s);
        }

        return result;
    }

    // get factorial
    private BigDecimal getFactorial(int f) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 1; i <= f; i++) {
            result = result.multiply(BigDecimal.valueOf(i));
        }

        return result;
    }
}
