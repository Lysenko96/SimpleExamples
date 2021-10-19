package net.gweep.task3.menu;

import static java.lang.System.lineSeparator;

import java.util.List;
import java.util.Scanner;

import net.gweep.task3.entity.Model;
import net.gweep.task3.logic.Logic;

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
		int value = 0;
		while (true) {
			System.out.print(menu);
			value = in.nextInt();
			if (value == 1) {
				MenuLogic.setValueOne(modelMenu, models);
			} else if (value == 2) {
				MenuLogic.setValueTwo();
			} else if (value == 3) {
				MenuLogic.setValueThree(modelMenu, models);
			} else if (value == 4) {
				MenuLogic.setValueFour(modelMenu, models);
			} else if (value == 5) {
				MenuLogic.setValueFive();
			} else if (value == 6) {
				MenuLogic.setValueSix();
			} else if (value == 7) {
				MenuLogic.setValueSeven();
			} else if (value == 8) {
				MenuLogic.setValueEight();
			}
			if (value == 0) {
				break;
			}
		}
		in.close();
	}

}
