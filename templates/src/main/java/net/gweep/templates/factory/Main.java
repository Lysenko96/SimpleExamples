package net.gweep.templates.factory;

import net.gweep.templates.factory.store.LondonPizzaStore;
import net.gweep.templates.factory.store.NYPizzaStore;
import net.gweep.templates.factory.store.PizzaStore;

public class Main {

	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore lStore = new LondonPizzaStore();
		System.out.println(nyStore.orderPizza("clam"));
		System.out.println(lStore.orderPizza("pepperoni"));
	}
}