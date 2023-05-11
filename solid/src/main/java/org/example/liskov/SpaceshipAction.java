package org.example.liskov;

public class SpaceshipAction implements Fly {

    @Override
    public void makeFly() {
        System.out.println("Spaceship fly!");
    }
}
