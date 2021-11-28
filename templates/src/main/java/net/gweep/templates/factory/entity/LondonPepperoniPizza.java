package net.gweep.templates.factory.entity;

import net.gweep.templates.factory.entity.iface.Pizza;

public class LondonPepperoniPizza extends Pizza {

	@Override
	public void prepare() {
		System.out.println("prepare pepperoniPizza");
	}

	@Override
	public void bake() {
		System.out.println("bake pepperoniPizza");
	}

	@Override
	public void cut() {
		System.out.println("cut pepperoniPizza");
	}

	@Override
	public void box() {
		System.out.println("box pepperoniPizza");
	}
}