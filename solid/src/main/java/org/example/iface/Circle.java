package org.example.iface;

//public class Circle implements BadShape{ - bad implements
public class Circle implements ICircle{

    @Override
    public void draw() {
        System.out.println("draw Circle!");
    }
}
