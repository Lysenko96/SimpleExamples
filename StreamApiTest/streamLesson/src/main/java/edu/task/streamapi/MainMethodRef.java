package edu.task.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import edu.task.entity.Car;
import static java.util.Comparator.comparing;
import static java.lang.System.out;

public class MainMethodRef {

	public static void main(String[] args) {
		List<Car> cars = new ArrayList<>();
		Car car1 = new Car("car1", 231.4f);
		Car car2 = new Car("car2", 131.6f);
		Car car3 = new Car("car3", 331.1f);
		cars.add(car1);
		cars.add(car3);
		cars.add(car2);
		cars.sort(comparing(Car::getModel));
		out.println(cars);// [Car [speed=231.4, model=car1], Car [speed=131.6, model=car2], Car
							// [speed=331.1, model=car3]]
		cars.sort(new CarComparator());
		out.println(cars); // [Car [speed=131.6, model=car2], Car [speed=231.4, model=car1], Car
							// [speed=331.1, model=car3]]

		// use anonymous class
		cars.sort(new Comparator<Car>() {

			@Override
			public int compare(Car arg0, Car arg1) {
				return arg1.getSpeed().compareTo(arg0.getSpeed());
			}

		});
		out.println(cars); // [Car [speed=331.1, model=car3], Car [speed=231.4, model=car1], Car
							// [speed=131.6, model=car2]]

		// use lambda
		cars.sort((c1, c2) -> c1.getSpeed().compareTo(c2.getSpeed()));
		
		out.println(cars); // [Car [speed=131.6, model=car2], Car [speed=231.4, model=car1], Car
							// [speed=331.1, model=car3]]

		Comparator<Car> carComparator = comparing((cc1) -> cc1.getSpeed());
		//cars.sort(comparing((cc1) -> cc1.getSpeed());
		cars.sort(carComparator.reversed());
		out.println(cars); // [Car [speed=331.1, model=car3], Car [speed=231.4, model=car1], Car
							// [speed=131.6, model=car2]]
	}

}

class CarComparator implements Comparator<Car> {

	@Override
	public int compare(Car c0, Car c1) {
		return c0.getSpeed().compareTo(c1.getSpeed());
	}

}
