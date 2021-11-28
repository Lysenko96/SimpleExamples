package net.gweep.templates.factory.store;

import net.gweep.templates.factory.entity.NYCheesePizza;
import net.gweep.templates.factory.entity.NYPepperoniPizza;
import net.gweep.templates.factory.entity.iface.Pizza;

public class NYPizzaStore extends PizzaStore {

	@Override
	public Pizza makePizza(String type) {
		System.out.println("NYPizzaStore");
		Pizza pizza = null;
		if (type.equals("pepperoni")) {
			pizza = new NYPepperoniPizza();
		} else if (type.equals("cheese")) {
			pizza = new NYCheesePizza();
		}
		return pizza;
	}
}