package net.gweep.templates2;

public class Knight extends Character {

	public Knight(WeaponBehavior w) {
		weapon = w;
	}

	@Override
	void fight() {
		weapon.useWeapon();
	}
}