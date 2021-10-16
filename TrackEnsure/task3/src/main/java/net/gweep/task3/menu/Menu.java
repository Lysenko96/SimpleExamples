package net.gweep.task3.menu;

import static java.lang.System.lineSeparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.gweep.task3.entity.Car;
import net.gweep.task3.entity.Model;
import net.gweep.task3.logic.Logic;

import static java.util.stream.Collectors.*;

public class Menu {

	public void show() {
		Logic logic = new Logic();
		Scanner in = new Scanner(System.in);
		StringBuilder menu = new StringBuilder("1 - add").append(lineSeparator()).append("2 - delete")
				.append(lineSeparator()).append("3 - show model cars in ascending order by year")
				.append(lineSeparator()).append("4 - show model cars exploiting more then n year")
				.append(lineSeparator()).append("5 - show cars by year, where price more then p")
				.append(lineSeparator()).append("6 - show cars descending order price").append(lineSeparator())
				.append("7 - show all cars model").append(lineSeparator()).append("8 - show model and cars for it")
				.append(lineSeparator()).append("0 - exit").append(lineSeparator()).append("Enter value: ");
		List<Model> models = logic.getModels();
		StringBuilder modelMenu = new StringBuilder("1 - " + models.get(0)).append(lineSeparator())
				.append("2 - " + models.get(1)).append(lineSeparator()).append("3 - " + models.get(2))
				.append(lineSeparator()).append("Enter model: ");
		StringBuilder yearMenu = new StringBuilder("Enter year: ");
		StringBuilder priceMenu = new StringBuilder("Enter price: ");
		StringBuilder numberMenu = new StringBuilder("Enter number: ");
		StringBuilder idMenu = new StringBuilder("Enter id: ");
		int value = 0;
		int id = 0;
		List<Car> cars = new ArrayList<>();
		while (true) {
			System.out.print(menu);
			value = in.nextInt();
			if (value == 1) {
				System.out.print(modelMenu);
				int model = in.nextInt();
				System.out.print(yearMenu);
				int year = in.nextInt();
				System.out.print(priceMenu);
				int price = in.nextInt();
				System.out.print(numberMenu);
				String number = in.next();
				cars.add(new Car(++id, models.get(model - 1), year, price, number));
			} else if (value == 2) {
				System.out.println(cars);
				System.out.print(idMenu);
				int index = in.nextInt();
				cars.remove(index - 1);
			} else if (value == 3) {
				System.out.print(modelMenu);
				int model = in.nextInt();
				System.out.println(logic.sortModelByYear(cars, models.get(model - 1)));
			} else if (value == 4) {
				System.out.print(modelMenu);
				int model = in.nextInt();
				System.out.println(cars.stream().map(Car::getYear).collect(toSet()));
				System.out.print(yearMenu);
				int year = in.nextInt();
				System.out.println(logic.exploitModelMoreThen(cars, models.get(model - 1), year));
			} else if (value == 5) {
				System.out.println(cars.stream().map(Car::getYear).collect(toSet()));
				System.out.print(yearMenu);
				int year = in.nextInt();
				System.out.println(cars.stream().map(Car::getPrice).collect(toSet()));
				System.out.print(priceMenu);
				int price = in.nextInt();
				System.out.println(logic.getByYearPriceMoThen(cars, year, price));
			} else if (value == 6) {
				System.out.println(logic.getByPriceReduceYearUp(cars));
			} else if (value == 7) {
				System.out.println(logic.getModels());
			} else if (value == 8) {
				System.out.println(logic.getModelCars(cars));
			}
			if (value == 0) {
				break;
			}
		}
		in.close();
	}
}