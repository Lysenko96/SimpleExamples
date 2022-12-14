package info.lysenko.anton.patterns.facade;

public class Projector {

    private DvdPlayer dvdPlayer;

    public Projector(DvdPlayer dvdPlayer) {
        this.dvdPlayer = dvdPlayer;
    }

    public void on() {
        System.out.println("on()");
    }

    void off() {
        System.out.println("off()");
    }

    void tvMode() {
        System.out.println("tvMode()");
    }

    void wideScreenMode() {
        System.out.println("wideScreenMode()");
    }

    @Override
    public String toString() {
        return "Projector{" +
                "dvdPlayer=" + dvdPlayer +
                '}';
    }
}
