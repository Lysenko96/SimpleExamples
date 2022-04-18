package net.pack.eckeljava.entity;

import net.pack.eckeljava.iface.Transport;

public class Train implements Transport {

    @Override
    public void move() {
        System.out.println("driving for railway...");
    }
}