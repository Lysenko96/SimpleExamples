package info.lysenko.anton.patterns.facade;

public class Amplifier {

    Tuner tuner;
    DvdPlayer dvdPlayer;
    CdPlayer cdPlayer;

    public Amplifier(Tuner tuner, DvdPlayer dvdPlayer, CdPlayer cdPlayer) {
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cdPlayer = cdPlayer;
    }

    public void on() {
        System.out.println("on()");
    }

    void off() {
        System.out.println("off()");
    }

    void setCd() {
        System.out.println("setCd()");
    }

    void setDvd(DvdPlayer dvdPlayer) {
        System.out.println("setDvd() " + dvdPlayer);
    }

    void setStereoSound() {
        System.out.println("setStereoSound()");
    }

    void setSurroundSound() {
        System.out.println("setSurroundSound()");
    }

    void setTuner() {
        System.out.println("setTuner()");
    }

    void setVolume(int value) {
        System.out.println("setVolume() " + value);
    }


    @Override
    public String toString() {
        return "Amplifier{" +
                "tuner=" + tuner +
                ", dvdPlayer=" + dvdPlayer +
                ", cdPlayer=" + cdPlayer +
                '}';
    }
}
