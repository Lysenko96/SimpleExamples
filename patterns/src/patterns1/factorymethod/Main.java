package patterns.factorymethod;

import java.util.Random;

public class Main {

	static Logistics logistics;

	public static void main(String[] args) {
		Random rand = new Random();
		int res = rand.nextInt();
		if (res % 2 == 0) {
			getType("SEA").planDelivery();
		} else {
			getType("ROAD").planDelivery();
		}
		System.out.println(res);
	}

	static Logistics getType(String type) {
		if (type.equals("SEA")) {
			logistics = new SeaLogistics();
		} else if (type.equals("ROAD")) {
			logistics = new RoadLogistics();
		}
		return logistics;
	}

}
