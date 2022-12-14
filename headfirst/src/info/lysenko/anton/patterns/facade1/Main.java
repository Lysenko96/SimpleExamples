package info.lysenko.anton.patterns.facade1;

public class Main {

    WeatherStation station = new WeatherStation(new Thermometer());

    public static void main(String[] args) {
        System.out.println(new Main().getTemp());
        System.out.println(new Main().getTemp(false));
    }

    public float getTemp(){
        Thermometer thermometer = station.getThermometer();
        return thermometer.getTemperature();
    }

    public float getTemp(boolean f){
        return station.getThermometer().getTemperature();
    }

}
