package net.gweep.weatherstation;

public class WeatherStation {

	public WeatherStation(Subject data) {
		WeatherFactory factory = new WeatherFactory();
		WeatherData weatherData = factory.getWeatherData(data);
		//weatherData.setMeasurements(12, 22, 33);
		ConditionDisplay display = new ConditionDisplay(weatherData);
		weatherData.setMeasurements(12, 22, 33);
		System.out.println(display);
//		display.update(weatherData.getTemp(), weatherData.getHumidity(), weatherData.getPressure());
//		System.out.println(display);
	}
}
