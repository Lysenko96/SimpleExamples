package net.gweep.templates.factory.entity;

import net.gweep.templates.factory.entity.iface.Pizza;

public class LondonClamPizza implements Pizza {

	@Override
	public void prepare() {
		System.out.println("prepare clamPizza");
	}

	@Override
	public void bake() {
		System.out.println("bake clamPizza");
	}

	@Override
	public void cut() {
		System.out.println("cut clamPizza");
	}

	@Override
	public void box() {
		System.out.println("box clamPizza");
	}
}
