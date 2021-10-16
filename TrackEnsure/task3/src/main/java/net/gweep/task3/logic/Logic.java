package net.gweep.task3.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

import java.time.LocalDate;

import net.gweep.task3.entity.Car;
import net.gweep.task3.entity.Model;

public class Logic {

	public List<Car> sortModelByYear(List<Car> cars, Model model) {
		return cars.stream().filter(car -> car.getModel().equals(model)).sorted(Comparator.comparing(Car::getYear))
				.collect(toList());
	}

	public List<Car> exploitModelMoreThen(List<Car> cars, Model model, int counter) {
		return cars.stream().filter(car -> car.getModel().equals(model))
				.filter(car -> (LocalDate.now().getYear() - car.getYear()) > counter).collect(toList());
	}

	public List<Car> getByYearPriceMoThen(List<Car> cars, int year, int price) {
		return cars.stream().filter(car -> car.getYear() == year).filter(car -> car.getPrice() > price)
				.collect(toList());
	}

	public List<Car> getByPriceReduceYearUp(List<Car> cars) {
		return cars.stream().sorted(Comparator.comparing(Car::getPrice).reversed()).collect(toList());
	}

	public List<Model> getModels() {
		Model[] arr = Model.values();
		List<Model> models = new ArrayList<>();
		Collections.addAll(models, arr);
		return models;
	}

	public Map<Model, List<Car>> getModelCars(List<Car> cars) {
		Map<Model, List<Car>> map = new EnumMap<>(Model.class);
		for (Model m : getModels()) {
			List<Car> newCars = new ArrayList<>();
			for (Car car : cars) {
				if (car.getModel().equals(m)) {
					newCars.add(car);
					map.put(m, newCars);
				}
			}
		}
		return map;
	}
}