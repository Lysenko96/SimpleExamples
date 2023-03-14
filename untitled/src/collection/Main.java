package collection;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println(isIsogram(""));
        System.out.println(new Main().findNextSquare(121));
        System.out.println(new Main().sum(Arrays.asList(1,5,"3","2")));
    }

    public static boolean  isIsogram(String str) {
        Set<String> set = new HashSet<>(Arrays.asList(str.toLowerCase().split("")));
        return set.size() == str.length() || set.size() == 1;
    }

    public static long findNextSquare(long sq) {
        if(Math.pow((int)Math.sqrt(sq), 2) != sq) return -1;
        return (long) Math.pow((int)Math.sqrt(sq) + 1, 2);
    }

    public int sum(List<?> mixed) {
        List<Integer> result = new ArrayList<>();
        for(Object o : mixed){
            if(o instanceof String) result.add(Integer.valueOf(o.toString()));
            else result.add((Integer) o);
        }
        return result.stream().mapToInt(Integer::intValue).sum();
    }

}
