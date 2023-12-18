package com.example.javabasic.pattern;

public class Proxy extends Entity{

    int random(int value){
        System.out.println("Proxy");
        return super.random(value);
    }

    public static void main(String[] args) {
        test(new Proxy(), 2);
        test(new Entity(), 3);
    }

    static void test(Entity proxy, int value){
        System.out.println(proxy.random(value));
    }
}
