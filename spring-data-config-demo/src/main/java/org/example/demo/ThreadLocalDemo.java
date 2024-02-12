package org.example.demo;

public class ThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> stringThreadLocal = new ThreadLocal<>();
        stringThreadLocal.set("Hello Java World!");
        System.out.println(stringThreadLocal.get());
    }
}
