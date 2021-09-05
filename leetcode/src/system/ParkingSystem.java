package system;

public class ParkingSystem {

	private int big;
	private int medium;
	private int small;

	public ParkingSystem() {
	}

	public ParkingSystem(int big, int medium, int small) {
		this.big = big;
		this.medium = medium;
		this.small = small;
	}

	public boolean addCar(int carType) {
		if (carType == 1) {
			if (big <= 0) {
				return false;
			}
			big--;
		} else if (carType == 2) {
			if (medium <= 0) {
				return false;
			}
			medium--;
		} else if (carType == 3) {
			if (small <= 0) {
				return false;
			}
			small--;
		}
		return true;
	}

	public static void main(String[] args) {
		ParkingSystem system = new ParkingSystem(1, 1, 0);
		system.addCar(1);
		system.addCar(2);
		system.addCar(3);
		system.addCar(1);
	}
}
