package com.lysenko;

import java.util.function.Predicate;
import java.util.function.Supplier;

class App {
    public static void main(String[] args) {

    }
}

class A {

    static int method() {
        return 0;
    }

    int method1() {
        return 0;
    }

    public static class B {

        static int method() {
            return 1;
        }
    }

    public static void main(String[] args) {
        Supplier<?> s = B::method;
        Supplier<?> s1 = A::method;
        Supplier<?> s3 = A::new;
        Predicate<String> s4 = String::isEmpty;
        A a = new A();
        Supplier<?> s5 = a::method1;
    }
}

class B1 {
    void method1(){
        System.out.println("B1");
    }

    void method(){
        System.out.println("B");
    }
}
class A1 extends B1 {
    void method2(){
        System.out.println("A1");
    }

    @Override
    void method() {
        System.out.println("A");
    }

    public static void main(String[] args) {
        B1 b1 = new A1();
        ((A1)b1).method1(); // B1
        ((A1)b1).method2(); // A1
        ((A1)b1).method(); // A
        ((B1)b1).method(); // A

        //A1 a1 = (A1) new B1();
        //a1.method(); //ClassCastException
    }
}