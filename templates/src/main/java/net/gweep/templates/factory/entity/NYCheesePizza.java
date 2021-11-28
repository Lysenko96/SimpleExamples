package net.gweep.templates.factory.entity;

import net.gweep.templates.factory.entity.iface.Pizza;

public class NYCheesePizza extends Pizza {

	public NYCheesePizza() {
		name = "NY Cheese Pizza";
		dough = "Thin Crust";
		sauce = "Marinara Sauce";
		
		toppings.add("Grated Reggiano Cheese");
	}
}