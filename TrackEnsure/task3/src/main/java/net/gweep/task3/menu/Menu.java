package net.gweep.task3.menu;

import static java.lang.System.lineSeparator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import net.gweep.task3.entity.Car;
import net.gweep.task3.entity.Model;
import net.gweep.task3.fileworker.FileWorker;
import net.gweep.task3.logic.Logic;

import static java.util.stream.Collectors.*;

public class Menu {

	private static Scanner in = new Scanner(System.in);
	private static StringBuilder yearMenu = new StringBuilder("Enter year: ");
	private static StringBuilder priceMenu = new StringBuilder("Enter price: ");
	private static StringBuilder numberMenu = new StringBuilder("Enter number: ");
	private static StringBuilder idMenu = new StringBuilder("Enter id: ");
	private static StringBuilder writeMenu = new StringBuilder("1 - write in file").append(lineSeparator())
			.append("2 - not write").append(lineSeparator()).append("Enter: ");
	private static StringBuilder fileMenu = new StringBuilder("Enter fileName: ");
	private static int id;
	private static Logic logic = new Logic();
	private static List<Car> carsToFile = new ArrayList<>();
	private static List<Car> cars = new ArrayList<>();
	private static FileWorker fileWorker = new FileWorker();

	public void show() {
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
		int value = 0;
		while (true) {
			System.out.print(menu);
			value = in.nextInt();
			if (value == 1) {
				setValueOne(modelMenu, models);
			} else if (value == 2) {
				setValueTwo();
			} else if (value == 3) {
				setValueThree(modelMenu, models);
			} else if (value == 4) {
				setValueFour(modelMenu, models);
			} else if (value == 5) {
				setValueFive();
			} else if (value == 6) {
				setValueSix();
			} else if (value == 7) {
				setValueSeven();
			} else if (value == 8) {
				setValueEight();
			}
			if (value == 0) {
				break;
			}
		}
		in.close();
	}

	static void setValueOne(StringBuilder modelMenu, List<Model> models) {
		System.out.print(modelMenu);
		int model = in.nextInt();
		System.out.print(yearMenu);
		int year = in.nextInt();
		System.out.print(priceMenu);
		int price = in.nextInt();
		System.out.print(numberMenu);
		String number = in.next();
		cars.add(new Car(++id, models.get(model - 1), year, price, number));
	}

	static void setValueTwo() {
		System.out.println(cars);
		System.out.print(idMenu);
		int index = in.nextInt();
		cars.remove(index - 1);
	}

	static void setValueThree(StringBuilder modelMenu, List<Model> models) {
		System.out.print(modelMenu);
		int model = in.nextInt();
		carsToFile = logic.sortModelByYear(cars, models.get(model - 1));
		System.out.println(carsToFile);
		writeInFile();
	}

	static void setValueFour(StringBuilder modelMenu, List<Model> models) {
		System.out.print(modelMenu);
		int model = in.nextInt();
		System.out.println(cars.stream().map(Car::getYear).collect(toSet()));
		System.out.print(yearMenu);
		int year = in.nextInt();
		carsToFile = logic.exploitModelMoreThen(cars, models.get(model - 1), year);
		System.out.println(carsToFile);
		writeInFile();
	}

	static void setValueFive() {
		System.out.println(cars.stream().map(Car::getYear).collect(toSet()));
		System.out.print(yearMenu);
		int year = in.nextInt();
		System.out.println(cars.stream().map(Car::getPrice).collect(toSet()));
		System.out.print(priceMenu);
		int price = in.nextInt();
		System.out.println(logic.getByYearPriceMoThen(cars, year, price));
		carsToFile = logic.getByYearPriceMoThen(cars, year, price);
		writeInFile();
	}

	static void setValueSix() {
		System.out.println(logic.getByPriceReduceYearUp(cars));
		carsToFile = logic.getByPriceReduceYearUp(cars);
		writeInFile();
	}

	static void setValueSeven() {
		System.out.println(logic.getModels());
	}

	static void setValueEight() {
		System.out.println(logic.getModelCars(cars));
	}

	static void writeInFile() {
		System.out.print(writeMenu);
		int writeValue = in.nextInt();
		if (writeValue == 1) {
			System.out.print(fileMenu);
			String fileName = in.next();
			fileWorker.write(carsToFile, fileName);
		}
	}
}