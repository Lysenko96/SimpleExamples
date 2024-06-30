package org.example.lambda;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Function<String, Integer> function = Integer::valueOf;
        System.out.println(function.apply("1") + 1);
        Predicate<Integer> predicate = i -> i > 10;
        System.out.println(predicate.test(1));
        System.out.println(predicate.test(11));
        Consumer<String> consumer;
        consumer = System.out::println;
        consumer.accept("1");
        Supplier<Integer> supplier = () -> new Random().nextInt(10);
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        A a = new A();
        A.show();
        a.test();

        Optional<A> optional = Optional.ofNullable(null);
        optional.ifPresent(System.out::println);
        optional = Optional.of(a);
        a.setA(10);
        int s = optional.map(A::getA).get();
        System.out.println(s);
        optional.ifPresent(System.out::println);
        Deque<String> q = new ArrayDeque<>();
        SortedSet<Integer> sortedSet = new TreeSet<>(Comparator.reverseOrder());
        sortedSet.add(2);
        sortedSet.add(22);
        System.out.println(sortedSet);
        q.addFirst("1");
        q.addFirst("2");
        q.addFirst("3");
//        q.removeFirst();
        System.out.println(q);
        NavigableSet<Integer> navigableSet = new TreeSet<>(Comparator.reverseOrder());
        navigableSet.add(2);
        navigableSet.add(0);
        System.out.println(navigableSet.floor(1));
        System.out.println(navigableSet.ceiling(1));
        SortedMap<Integer, Integer> sortedMap = new TreeMap<>();
        sortedMap.put(11, 2);
        sortedMap.put(5, 2);
        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
        NavigableMap<Integer, Integer> navigableMap = new TreeMap<>();
        Iterator<?> it = navigableSet.iterator();
        List<?> list = new ArrayList<>(q);
        ListIterator<?> itl = list.listIterator();
        while (itl.hasNext()) System.out.println(itl.next());
        while (itl.hasPrevious()) {
            System.out.println(itl.previous());
            itl.remove();
        }
        Calendar calendar = Calendar.getInstance();
        TimeZone timeZone = calendar.getTimeZone();
        timeZone.observesDaylightTime();
        System.out.println(list);
//        while (it.hasNext()) { it.next(); it.remove();}
//        System.out.println(navigableSet);


    }
}

class A {

    private  int a;

    public static void show() {
    }

    public void test() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

@FunctionalInterface
interface MyFunc {

    Integer getValue(String s);
}
