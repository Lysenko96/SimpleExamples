package net.gweep.weatherbeta;

public class StatisticsDisplay extends WeatherData implements Updatable {

	StatisticsDisplay(int temp, int humidity, String pressure) {
		super(temp, humidity, pressure, new StatisticsDisplay());
	}
	
	public StatisticsDisplay() {
	}

	public void update(int temp, int humidity, String pressure) {
		System.out.println("statistics");
		System.out.println(temp);
		System.out.println(humidity);
		System.out.println(pressure);
	}
}