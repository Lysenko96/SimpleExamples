package net.gweep.weatherstation;

public interface Observer {

	void update(int temp, int humidity, int pressure);
}
