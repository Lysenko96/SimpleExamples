package net.pack.eckeljava.entity;

import net.pack.eckeljava.iface.Transport;

public class Plane implements Transport {

    @Override
    public void move() {
        System.out.println("flying in sky...");
    }
}