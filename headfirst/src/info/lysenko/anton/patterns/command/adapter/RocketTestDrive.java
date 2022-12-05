package info.lysenko.anton.patterns.command.adapter;

public class RocketTestDrive {

    public static void main(String[] args) {
        SpaceX spaceX = new SpaceX();
        Antonov antonov = new Antonov();
        antonov.fly();
        antonov.description();
        PlaneAdapter adapter = new PlaneAdapter(antonov);
        new RocketTestDrive().testRocket(adapter);
        new RocketTestDrive().testRocket(spaceX);
    }

    public void testRocket(Rocket rocket){
        rocket.description();
        rocket.spaceFly();
    }

}
