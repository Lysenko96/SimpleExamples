package net.gweep.task3.logic;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

import java.util.stream.Stream;

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
		return cars.stream().sorted(Comparator.comparing(Car::getPrice).reversed().thenComparing(Car::getYear))
				.collect(toList());
	}

	public List<Model> getModels() {
		return Stream.of(Model.values()).collect(toList());
	}

	public Map<Model, List<Car>> getModelCars(List<Car> cars) {
		return cars.stream().collect(groupingBy(Car::getModel));
	}
}