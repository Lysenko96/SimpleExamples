package net.gweep.templates.factory.entity;

import net.gweep.templates.factory.entity.iface.Pizza;

public class NYPepperoniPizza implements Pizza{

	@Override
	public void prepare() {
		System.out.println("prepare NYpepperoniPizza");
	}

	@Override
	public void bake() {
		System.out.println("bake NYpepperoniPizza");
	}

	@Override
	public void cut() {
		System.out.println("cut NYpepperoniPizza");
	}

	@Override
	public void box() {
		System.out.println("box NYpepperoniPizza");
	}
}
