package net.gweep.templates.factory.entity;

import net.gweep.templates.factory.entity.iface.Pizza;

public class LondonCheesePizza extends Pizza {

	public LondonCheesePizza() {
		name = "London Cheese Pizza";
		dough = "Extra Thick Crust";
		sauce = "Tomato Sauce";
		
		toppings.add("Shredded Mozzarella Cheese");
	}

	@Override
	public void cut() {
		System.out.println("Cutting the pizza into square slices");
	}
}