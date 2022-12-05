package info.lysenko.anton.patterns.command.adapter;

public class SpaceX implements Rocket {

    @Override
    public void spaceFly() {
        System.out.println("Fly in space");
    }

    @Override
    public void description() {
        System.out.println("SpaceX rocket");
    }
}
