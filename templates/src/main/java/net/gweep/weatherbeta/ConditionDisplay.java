package net.gweep.weatherbeta;

public class ConditionDisplay extends WeatherData implements Updatable {

	ConditionDisplay(int t, int h, String p) {
		super(t, h, p, new ConditionDisplay());
	}

	public ConditionDisplay() {
	}

	public void update(int temp, int humidity, String pressure) {
		System.out.println("current state");
		System.out.println(temp);
		System.out.println(humidity);
		System.out.println(pressure);
	}
}