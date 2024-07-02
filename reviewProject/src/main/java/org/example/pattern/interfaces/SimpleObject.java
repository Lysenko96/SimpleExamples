package org.example.pattern.interfaces;

public class SimpleObject implements Interface {

    @Override
    public void operation() {
        System.out.println("operation");
    }

    public static void main(String[] args) {
        new SimpleObject().operation();
    }
}
