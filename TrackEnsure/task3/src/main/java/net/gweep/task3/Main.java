package net.gweep.task3;

import java.util.List;

import net.gweep.task3.entity.Car;
import net.gweep.task3.entity.Model;
import net.gweep.task3.logic.Logic;

public class Main {

	private static List<Car> cars = List.of(new Car(1, Model.TESLA, 2020, 225000, "AK7689AK"),
			new Car(2, Model.BMW, 2019, 250000, "AH3691AC"), new Car(3, Model.PORSCHE, 2021, 225000, "AA7777AK"),
			new Car(4, Model.BMW, 2020, 270000, "AA8921AC"));

	public static void main(String[] args) {
		Logic logic = new Logic();
		System.out.println(logic.sortModelByYear(cars, Model.BMW));
		System.out.println(logic.exploitModelMoreThen(cars, Model.BMW, 1));
		System.out.println(logic.getByYearPriceMoThen(cars, 2020, 250000));
		System.out.println(logic.getByPriceReduceYearUp(cars));
		System.out.println(logic.getModels(cars));
		System.out.println(logic.getModelCars(cars));
	}

	public static List<Car> getCars() {
		return cars;
	}

	public static void setCars(List<Car> cars) {
		Main.cars = cars;
	}
}