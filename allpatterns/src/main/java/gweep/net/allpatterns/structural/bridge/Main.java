package gweep.net.allpatterns.structural.bridge;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Car> cars = new ArrayList<>();
		cars.add(new Bmw(new CorpusBuilder()));
		cars.add(new Tesla(new MotorBuilder()));
		for (Car car : cars) {
			car.drive(car.getClass());
		}
	}
}
