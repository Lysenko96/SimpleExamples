package net.gweep.weatherbeta;

public abstract class WeatherData {

	protected Updatable updatable;
	protected int temperature;
	protected int humidity;
	protected String pressure;

	public WeatherData(int t, int h, String p, Updatable u) {
		temperature = t;
		humidity = h;
		pressure = p;
		updatable = u;

	}

	public WeatherData() {
		
	}

	void measurementsChanged() {
		updatable.update(getTemperature(), getHumidity(), getPressure());
	}

	int getTemperature() {
		return temperature;
	}

	int getHumidity() {
		return humidity;
	}

	String getPressure() {
		return pressure;
	}

	public Updatable getUpdatable() {
		return updatable;
	}

	public void setUpdatable(Updatable updatable) {
		this.updatable = updatable;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

}
