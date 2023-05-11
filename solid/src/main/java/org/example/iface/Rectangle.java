package org.example.iface;

//public class Rectangle implements BadShape{ - bad implements
public class Rectangle implements IRectangle{ // good implements


    @Override
    public void draw() {
        System.out.println("draw Rectangle!");
    }
}
