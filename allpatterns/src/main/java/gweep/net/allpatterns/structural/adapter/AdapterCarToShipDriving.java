package gweep.net.allpatterns.structural.adapter;

public class AdapterCarToShipDriving extends ShipDriver implements CarDriver {

	@Override
	public void upSpeedCar() {
		upSpeedShip();
	}

	@Override
	public void stopCar() {
		stopShip();
	}

	@Override
	public void changeSpeedCar() {
		changeSpeedShip();
	}
}