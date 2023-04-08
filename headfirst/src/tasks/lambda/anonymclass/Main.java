package tasks.lambda.anonymclass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        List<Double> list = new ArrayList<>(Arrays.asList(2.3, 4.6));
        System.out.println(main.filter(list));
        System.out.println(main.filterFunc(list, a -> a.intValue() % 2 == 0));
    }

    public <T extends Number> List<T> filterFunc(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) result.add(e);
        }
        return result;
    }

    public <T extends Number> List<T> filter(List<T> list) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (e.intValue() % 2 == 0) result.add(e);
        }
        return result;
    }
}