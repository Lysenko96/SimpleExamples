package net.pack.weapon.entity;

import net.pack.weapon.aspect.Fire;

public class Sword extends Weapon implements Fire {

	public Sword() {

	}

	public Sword(String name) {
		super(name, new Sword(), null);
	}

	@Override
	public void fire() {
		System.out.println("Fire Sword");
	}
}