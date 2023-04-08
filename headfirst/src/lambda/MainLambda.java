package lambda;

import info.lysenko.anton.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainLambda {

    int global = 33;

    public static void main(String[] args) {
        new MainLambda().show();
    }
    // operator and expression, operator it's action from expression example (Integer i) -> { return "hello" + i; };
    void show(){
        int i = 1;
        Stream.of("123","1").map(s -> {return "awe" + i;});
        Thread t = new Thread(() -> {});
        List<A> aList = Stream.of(new A(2), new A(3)).filter(a -> a.getA() == 3).collect(Collectors.toList());
        List<A> aList1 = new ArrayList<>(Arrays.asList(new A(2), new A(3)));
        List<Integer> list = new ArrayList<>();
        list = aList1.stream().map(a -> a.getA() + 1).collect(Collectors.toList());
        int port = 4224;
        // capturing lambdas
        // stack (local) heap (global)
        Runnable r = () -> System.out.println(port);
        Runnable r1 = () -> System.out.println(--global);
        Runnable r2 = () -> {
            global *= 2;
            System.out.println(--global);
        };
//        Runnable r = () -> {
//            port += 1;
//            System.out.println(port);
 //           port += 1;
//        };
        new Thread(r).start();
        new Thread(r1).start();
        new Thread(r2).start();
    }
}

class A {
    int a;

    public A(){

    }
    public A(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}

@FunctionalInterface
interface Adder {
    void add(int a, int b);

    default void show(){ };

    default String getString(String str) {
        return str;
    }
}
@FunctionalInterface
interface SmartAdder extends Adder {
    //@Override
    //void add(double a, double b);
}
