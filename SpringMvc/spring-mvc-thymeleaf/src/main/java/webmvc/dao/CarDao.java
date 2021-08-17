package webmvc.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import webmvc.model.Car;

@Component
public class CarDao {

	private static int id;
	private List<Car> cars = Arrays.asList(new Car(++id, "Tesla", 235), new Car(++id, "BMW", 220),
			new Car(++id, "Porsche", 255));

	public List<Car> getAll() {
		return cars;
	}

	public Car getById(int id) {
		return cars.get(id - 1);
	}

}
