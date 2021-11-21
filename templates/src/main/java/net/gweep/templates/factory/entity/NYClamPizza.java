package net.gweep.templates.factory.entity;

import net.gweep.templates.factory.entity.iface.Pizza;

public class NYClamPizza implements Pizza {

	@Override
	public void prepare() {
		System.out.println("prepare NYclamPizza");
	}

	@Override
	public void bake() {
		System.out.println("bake NYclamPizza");
	}

	@Override
	public void cut() {
		System.out.println("cut NYclamPizza");
	}

	@Override
	public void box() {
		System.out.println("box NYclamPizza");
	}
}
