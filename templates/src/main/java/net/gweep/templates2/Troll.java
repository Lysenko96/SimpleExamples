package net.gweep.templates2;

public class Troll extends Character {

	Troll(WeaponBehavior w) {
		weapon = w;
	}

	@Override
	void fight() {
		weapon.useWeapon();
	}
}