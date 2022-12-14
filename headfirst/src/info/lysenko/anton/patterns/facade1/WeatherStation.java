package info.lysenko.anton.patterns.facade1;

public class WeatherStation {

    private Thermometer thermometer;

    public WeatherStation(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public Thermometer getThermometer() {
        return thermometer;
    }

    public void setThermometer(Thermometer thermometer) {
        this.thermometer = thermometer;
    }
}
