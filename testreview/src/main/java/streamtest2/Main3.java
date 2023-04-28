package streamtest2;

import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main3 {

    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 12).boxed().collect(Collectors.toList());
        Spliterator<Integer> spliterator = list.spliterator();
        System.out.println(spliterator);
        //spliterator.forEachRemaining(System.out::println);
        System.out.println(spliterator.getExactSizeIfKnown());
       // System.out.println(spliterator.trySplit());
        //spliterator.forEachRemaining(System.out::println);
        spliterator.trySplit().forEachRemaining(System.out::println);
        System.out.println(spliterator.hasCharacteristics(Spliterator.ORDERED));
        Set<Double> list1 = Stream.generate(Math::random).limit(5).collect(Collectors.toCollection(HashSet::new));
        HashSet<Double> list2 = Stream.generate(Math::random).limit(5).collect(Collectors.toCollection(HashSet::new));
        Spliterator<Double> spliterator1 = list1.spliterator();
        System.out.println(list1);
        System.out.println(spliterator1.hasCharacteristics(Spliterator.ORDERED));
    }
}
