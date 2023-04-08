package tasks.lambda.functionalprogramming;

import java.util.function.ToIntBiFunction;

public class Main implements IntToFunc {

    public static void main(String[] args) {
        Main main = new Main();
        main.calculate(2,2);
        main.apply((a, b) -> a + b, 2, 2);
    }

    public int calculate(int a, int b){
        return a + b;
    }

    @Override
    public int apply(ToIntBiFunction<Integer, Integer> f, int a, int b) {
        return f.applyAsInt(a, b);
    }
}

@FunctionalInterface
interface IntToFunc {

    int apply(ToIntBiFunction<Integer, Integer> f, int a, int b);
}
