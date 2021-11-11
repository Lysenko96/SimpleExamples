package net.gweep.weatherstation;

public class ConditionDisplay implements Observer, Display {

	private int temp;
	private int humidity;
	private Subject weatherData;

	public ConditionDisplay(Subject subject) {
		this.weatherData = subject;
		weatherData.registerObserver(this);
	}

	@Override
	public void display() {
		toString();
	}

	@Override
	public void update(int temp, int humidity, int pressure) {
		this.temp = temp;
		this.humidity = humidity;
		display();
	}

	@Override
	public String toString() {
		return "ConditionDisplay [temp=" + temp + ", humidity=" + humidity + ", weatherData=" + weatherData + "]";
	}
}
