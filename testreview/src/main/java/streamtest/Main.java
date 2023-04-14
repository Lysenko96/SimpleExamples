package streamtest;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<A> l = Arrays.asList(new A("abc12"), new A("abc12"), new A("cde532"), new A("ghf124142"));
        List<Integer> result = l.stream()
                .map(e -> {
                    System.out.println(e.getName());
                    return e.getName();
                })
                .map(e -> {
                    System.out.println(e.length());
                    return e.length();
                })
                .collect(Collectors.toList());
        List<A> result1 = l.stream().distinct().collect(Collectors.toList());
        Stream<A> result2 = l.stream().limit(1);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        List<A> result3 = result2.collect(Collectors.toList());
        System.out.println(result3);
        result2.forEach(System.out::print);
    }
}

class A {

    private String name;

    public A() {
    }

    public A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "A{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return Objects.equals(name, a.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
