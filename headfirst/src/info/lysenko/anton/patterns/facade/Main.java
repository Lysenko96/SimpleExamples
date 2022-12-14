package info.lysenko.anton.patterns.facade;

public class Main {

    public static void main(String[] args) {
        Tuner tuner = new Tuner();
        DvdPlayer dvdPlayer = new DvdPlayer();
        CdPlayer cdPlayer = new CdPlayer();
        Projector projector = new Projector(dvdPlayer);
        TheaterLights lights = new TheaterLights();
        Amplifier amp = new Amplifier(tuner, dvdPlayer, cdPlayer);
        Screen screen = new Screen();
        Popcorn popcorn = new Popcorn();
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade(amp, tuner, dvdPlayer, cdPlayer, projector, lights, screen, popcorn);
        homeTheaterFacade.watchMovie("Wednesday");
        System.out.println();
        homeTheaterFacade.endMovie();
    }
}
