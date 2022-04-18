package net.pack.eckeljava;

import net.pack.eckeljava.entity.Car;
import net.pack.eckeljava.entity.Plane;
import net.pack.eckeljava.entity.Ship;
import net.pack.eckeljava.entity.Train;
import net.pack.eckeljava.iface.Transport;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        List<Transport> transports = Arrays.asList(new Car(),new Train(), new Plane(), new Ship());
        for(Transport transport : transports){
            main.showRoadType(transport);
        }
    }

    private void showRoadType(Transport transport){
        transport.move();
    }

}