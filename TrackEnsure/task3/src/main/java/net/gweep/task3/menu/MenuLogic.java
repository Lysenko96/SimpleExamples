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

public class MenuLogic {

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