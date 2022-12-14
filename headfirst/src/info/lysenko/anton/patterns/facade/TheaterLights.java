package info.lysenko.anton.patterns.facade;

public class TheaterLights {

    public void on() {
        System.out.println("on()");
    }

    void off() {
        System.out.println("off()");
    }

    void dim(int value) {
        System.out.println("dim() " + value);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
