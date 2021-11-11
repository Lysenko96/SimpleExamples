package net.gweep.weatherbeta;

public class PredictionDisplay extends WeatherData implements Updatable {

	PredictionDisplay(int temp, int humidity, String pressure) {
		super(temp, humidity, pressure, new PredictionDisplay());
	}
	
	public PredictionDisplay() {
	}

	public void update(int temp, int humidity, String pressure) {
		System.out.println("prediction");
		System.out.println(temp);
		System.out.println(humidity);
		System.out.println(pressure);
	}
}
