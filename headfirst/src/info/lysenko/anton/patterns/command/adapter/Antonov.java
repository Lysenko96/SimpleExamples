package info.lysenko.anton.patterns.command.adapter;

public class Antonov implements Plane {

    @Override
    public void fly() {
        System.out.println("Fly in stratosphere");
    }

    @Override
    public void description() {
        System.out.println("Antonov plane");
    }
}
