package gweep.net.allpatterns.structural.adapter;

public class Main {

	public static void main(String[] args) {
		CarDriver driver = new AdapterCarToShipDriving();

		driver.upSpeedCar();
		driver.stopCar();
		driver.changeSpeedCar();
	}
}