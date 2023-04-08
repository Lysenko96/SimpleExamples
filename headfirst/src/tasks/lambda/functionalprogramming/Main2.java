package tasks.lambda.functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public static void main(String[] args) {
        Main2 main2 = new Main2();
        main2.calculate();
        main2.apply();
    }

    public void calculate(){
        int b = 0;
        List<Integer> list = Arrays.asList(1, 2);
        for (Integer i : list) {
            int val = i + 2;
            list.set(b, val + ++b);
        }
        return;
    }

    public void apply(){
        int b = 0;
        List<Integer> list = Arrays.asList(1, 2);
        list.stream().map(i -> {
            int val = i + 2;
            list.set(b, val);
            //list.set(b, val + ++b);
            return list;
        }).collect(Collectors.toList());
    }

}
