package net.gweep.weatherstation;

public class WeatherFactory implements Weather{

	@Override
	public WeatherData getWeatherData(Subject data) {
		return (WeatherData) data;
	}
}
