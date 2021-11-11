package net.gweep.weatherstation;

public interface Subject {

	void registerObserver(Observer o);
	
	void removeObserver(Observer o);
	
	void notifyObservers();
}
