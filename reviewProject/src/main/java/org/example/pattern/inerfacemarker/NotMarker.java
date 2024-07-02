package org.example.pattern.inerfacemarker;

public class NotMarker implements Generic{

    public void marker() throws Exception {
        if(isMarked(this.getClass())) System.out.println("not marker");
    }
}
