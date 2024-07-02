package org.example.pattern.inerfacemarker;

public class Marker implements Markable, Generic {

    public void marker() throws Exception {
        if (isMarked(this.getClass())) System.out.println("marker");
    }
}
