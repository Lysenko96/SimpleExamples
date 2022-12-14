package info.lysenko.anton.patterns.facade;

public class CdPlayer {

    public void on() {
        System.out.println("on()");
    }

    void off() {
        System.out.println("off()");
    }

    void eject() {
        System.out.println("eject()");
    }


    void pause() {
        System.out.println("pause()");
    }


    void play(String movie) {
        System.out.println("play() " + movie);
    }


    void stop() {
        System.out.println("stop()");
    }

}
