package edu.task.streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
		List<Car> cars = asList(new Car("Audi", 150f, Type.CROSSOVER), new Car("Lamba", 310f, Type.SPORT),
				new Car("Tesla", 250f, Type.CROSSOVER), new Car("Porshe", 190f, Type.SPORT)); // sort for model
		out.println(getSortModel(cars)); // [Tesla, Lamba]
		out.println(getSortModelStream(cars)); // [Tesla, Lamba]
		Map<Type, List<Car>> carsByType = cars.stream().collect(groupingBy(Car::getType));
		out.println(carsByType); // {SPORT=[Car [speed=310.0, model=Lamba, type=SPORT], Car [speed=190.0,
									// model=Porshe, type=SPORT]], CROSSOVER=[Car [speed=150.0, model=Audi,
									// type=CROSSOVER], Car [speed=250.0, model=Tesla, type=CROSSOVER]]}

		out.println(getCrossover(cars)); // [Car [speed=150.0, model=Audi, type=CROSSOVER]]
		out.println(getModelsLength(cars)); // [4, 5, 5, 6]
		out.println(getModelsUniqueChar(cars)); // [A, u, d, i, L, a, m, b, a, T, e, s, l, a, P, o, r, s, h, e]
		out.println(getModelsUniqueCharArray(cars)); // [A, u, d, i, L, a, m, b, T, e, s, l, P, o, r, h]
	}

	public static void main(String[] args) {
		new MainStreamTest();
	}

	// with streamApi

	List<String> getSortModelStream(List<Car> cars) {
		return cars.stream().filter(c -> c.getSpeed() > 200).sorted(comparing(Car::getSpeed)).map(Car::getModel)
				.collect(toList());
	}

	// without streamApi
	List<String> getSortModel(List<Car> cars) {
		List<Car> lowSpeedCars = new ArrayList<>();
		for (Car car : cars) {
			if (car.getSpeed() > 200) {
				lowSpeedCars.add(car);
			}
		}
		sort(lowSpeedCars, new CarComparatorNew());
		List<String> lowSpeedCarsModels = new ArrayList<>();
		for (Car car : lowSpeedCars) {
			lowSpeedCarsModels.add(car.getModel());
		}
		return lowSpeedCarsModels;
	}

	List<Car> getCrossover(List<Car> cars) {
		return cars.stream().filter(car -> car.getType() == Type.CROSSOVER).limit(1).collect(toList());
	}

	List<Integer> getModelsLength(List<Car> cars) {
		return cars.stream().map(Car::getModel).map(String::length).collect(toList());
	}

	// distinct() - incorrect use of map to find unique characters from a list world

	String getModelsUniqueChar(List<Car> cars) {
		StringBuilder s = new StringBuilder();
		return cars.stream().map(car -> {
			StringBuilder modelChars = s.append(car.getModel());
			return modelChars.toString().split("");
		}).distinct().map(Arrays::toString).distinct().collect(toList()).get(3);
	}

	// distinct() - correct
	List<String> getModelsUniqueCharArray(List<Car> cars) {
		return cars.stream().map(car -> {
			return car.getModel().split("");
		}).flatMap(Arrays::stream).distinct().collect(toList());
	}

}

class CarComparatorNew implements Comparator<Car> {

	@Override
	public int compare(Car c0, Car c1) {
		return Float.compare(c0.getSpeed(), c1.getSpeed());
	}

}
