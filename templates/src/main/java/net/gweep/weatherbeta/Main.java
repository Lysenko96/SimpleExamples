package net.gweep.weatherbeta;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		WeatherData d = new PredictionDisplay(rand.nextInt(10), rand.nextInt(10), "up");
		WeatherData d1 = new ConditionDisplay(1, 10, "down");

		WeatherData d2 = new StatisticsDisplay(rand.nextInt(10), rand.nextInt(10), "up");
		//d.measurementsChanged();
		d1.measurementsChanged();
		//d2.measurementsChanged();
		d1.setTemperature(2);
		d1.setHumidity(4);
		d1.setPressure("up");
		d1.measurementsChanged();
	}
}