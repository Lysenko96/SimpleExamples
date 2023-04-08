package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.showFunc();
        main.showState();
    }

    void showState() {
        int b = 0;
        List<Integer> list = Arrays.asList(1, 2);
        for (Integer i : list) {
            int val = list.get(i) + 2;
            list.set(i, val + ++b);
        }
    }

    void showFunc() {
        int b = 1;
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.stream().map(i -> {
            return i + 2 + b;
        }).collect(Collectors.toList()).forEach(System.out::println);
    }

}
