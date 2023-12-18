package com.example.javabasic.methodreference;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntSupplier;

public class MethodReference {

    public static void main(String[] args) {
        Function<String, String> join = s -> String.join(s, "123","456");
        Function<String, String> join2 = String::valueOf; // static method reference (Class::staticMethodName)
        System.out.println(join.apply("44"));
        System.out.println(join2.apply(null).charAt(0));
        ThreadLocalRandom random = ThreadLocalRandom.current();
        IntSupplier intSupplier = random::nextInt; // non-static method reference (obj::methodName)
        System.out.println(intSupplier.getAsInt());
        Function<String, String> function = String::intern; // static reference of non-static method (Class::nonStaticMethodName)
        System.out.println(function.apply(new String("123")) == "123"); // true
        System.out.println(new String("123") == "123"); // false
        BiFunction<String, Integer, String> substr = String::substring;
        System.out.println(substr.apply("12345", 3));
    }
}
