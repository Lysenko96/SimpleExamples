package org.example.liskov;

public class PlainAction implements Fly {

    @Override
    public void makeFly() {
        System.out.println("Plain fly!");
    }
}
