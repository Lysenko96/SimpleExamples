package streamtest2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main2 {

    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1_000_000_000).parallel().filter(x-> {
            System.out.println(Thread.currentThread());
            return true;}).reduce(0, Integer::sum);
        System.out.println(System.currentTimeMillis() - start);

        long start2 = System.currentTimeMillis();
        IntStream.rangeClosed(1, 1_000_000_000).sequential().filter(x -> x % 2 == 0).parallel().reduce(0, Integer::sum);
        System.out.println(System.currentTimeMillis() - start2);




    }
}
