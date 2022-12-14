package info.lysenko.anton.patterns.facade;

public class HomeTheaterFacade {

    Amplifier amp;
    Tuner tuner;
    DvdPlayer dvdPlayer;
    CdPlayer cdPlayer;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    Popcorn popcorn;

    public HomeTheaterFacade(Amplifier amp, Tuner tuner, DvdPlayer dvdPlayer, CdPlayer cdPlayer, Projector projector, TheaterLights lights, Screen screen, Popcorn popcorn) {
        this.amp = amp;
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popcorn = popcorn;
    }

    public void watchMovie(String movie) {
        System.out.println("Ready to watch movie...");
        popcorn.on();
        popcorn.pop();
        lights.dim(10);
        screen.down();
        projector.on();
        projector.wideScreenMode();
        amp.on();
        amp.setDvd(dvdPlayer);
        amp.setSurroundSound();
        amp.setVolume(5);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    void endMovie() {
        System.out.println("Shutting movie theater down...");
        popcorn.off();
        lights.on();
        screen.up();
        projector.off();
        amp.off();
        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.off();
    }


    void listenToCd() {
    }


    void endCd() {
    }


    void listenToRadio() {
    }


    void endRadio() {
    }

}
