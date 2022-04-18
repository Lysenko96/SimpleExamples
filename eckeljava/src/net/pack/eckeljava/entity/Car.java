package net.pack.eckeljava.entity;

import net.pack.eckeljava.iface.Transport;

public class Car implements Transport {

    @Override
    public void move() {
        System.out.println("driving to road...");
    }
}