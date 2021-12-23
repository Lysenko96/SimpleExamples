package net.pack.weapon.entity;

import net.pack.weapon.aspect.Fire;
import net.pack.weapon.aspect.Reload;

public class Bow extends Weapon implements Fire {

	public Bow() {

	}

	public Bow(String name, Fire fire, Reload reload) {
		super(name, fire, reload);
	}

	@Override
	public void fire() {
		System.out.println("Fire Bow");
	}
}