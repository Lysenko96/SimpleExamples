package net.pack.weapon.entity;

import net.pack.weapon.aspect.Fire;
import net.pack.weapon.aspect.Reload;

public class Ak47 extends Weapon implements Fire, Reload {

	public Ak47() {

	}

	public Ak47(String name) {
		super(name, new Ak47(), new Ak47());
	}

	@Override
	public void reload() {
		System.out.println("Reload Ak-47");
	}

	@Override
	public void fire() {
		System.out.println("Fire Ak-47");
	}
}