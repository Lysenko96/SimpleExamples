package edu.task.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.Collections.sort;
import static java.util.Arrays.asList;
import static java.lang.System.out;

import edu.task.behaviour.Type;
import edu.task.entity.Car;

public class MainStreamTest {

	MainStreamTest() {
		List<Car> lowSpeedCars = asList(new Car("Audi", 150f, Type.CROSSOVER), new Car("Lamba", 310f, Type.SPORT),
				new Car("Tesla", 250f, Type.SPORT), new Car("Porshe", 190f, Type.SPORT)); // sort for model
		out.println(getSortModel(lowSpeedCars)); // [Tesla, Lamba]
		out.println(getSortModelStream(lowSpeedCars)); // [Tesla, Lamba]
		Map<Type, List<Car>> carsByType = lowSpeedCars.stream().collect(groupingBy(Car::getType));
		out.println(carsByType); // {CROSSOVER=[Car [speed=150.0, model=Audi, type=CROSSOVER]], SPORT=[Car
									// [speed=310.0, model=Lamba, type=SPORT], Car [speed=250.0, model=Tesla,
									// type=SPORT], Car [speed=190.0, model=Porshe, type=SPORT]]}
	}

	public static void main(String[] args) {
		new MainStreamTest();
	}

	// with streamApi

	List<String> getSortModelStream(List<Car> lowSpeedCars) {
		return lowSpeedCars.stream().filter(c -> c.getSpeed() > 200).sorted(comparing(Car::getSpeed)).map(Car::getModel)
				.collect(toList());
	}

	// without streamApi
	List<String> getSortModel(List<Car> lowSpeedCars) {
		List<Car> lowSpeedCarsNew = new ArrayList<>();
		for (Car car : lowSpeedCars) {
			if (car.getSpeed() > 200) {
				lowSpeedCarsNew.add(car);
			}
		}
		sort(lowSpeedCarsNew, new CarComparatorNew());
		List<String> lowSpeedCarsModels = new ArrayList<>();
		for (Car car : lowSpeedCarsNew) {
			lowSpeedCarsModels.add(car.getModel());
		}
		return lowSpeedCarsModels;
	}

}

class CarComparatorNew implements Comparator<Car> {

	@Override
	public int compare(Car c0, Car c1) {
		return Float.compare(c0.getSpeed(), c1.getSpeed());
	}

}
