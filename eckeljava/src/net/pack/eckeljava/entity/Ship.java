package net.pack.eckeljava.entity;

import net.pack.eckeljava.iface.Transport;

public class Ship implements Transport {

    @Override
    public void move() {
        System.out.println("swimming for sea...");
    }
}