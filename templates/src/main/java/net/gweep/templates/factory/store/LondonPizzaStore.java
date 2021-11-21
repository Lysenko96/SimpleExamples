package net.gweep.templates.factory.store;

import net.gweep.templates.factory.entity.LondonClamPizza;
import net.gweep.templates.factory.entity.LondonPepperoniPizza;
import net.gweep.templates.factory.entity.iface.Pizza;

public class LondonPizzaStore extends PizzaStore{

	@Override
	public Pizza makePizza(String type) {
		System.out.println("LondonPizzaStore");
		Pizza pizza = null;
		if (type.equals("pepperoni")) {
			pizza = new LondonPepperoniPizza();
		} else if (type.equals("clam")) {
			pizza = new LondonClamPizza();
		}
		return pizza;
	}
}
