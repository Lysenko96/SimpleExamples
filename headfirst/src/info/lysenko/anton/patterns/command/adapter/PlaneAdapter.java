package info.lysenko.anton.patterns.command.adapter;

public class PlaneAdapter implements Rocket {

    private Plane plane;

    public PlaneAdapter(Plane plane) {
        this.plane = plane;
    }

    @Override
    public void spaceFly() {
        for (int i = 0; i < 5; i++)
            plane.fly();
    }

    @Override
    public void description() {
        plane.description();
    }
}
