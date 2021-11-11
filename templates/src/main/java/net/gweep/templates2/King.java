package net.gweep.templates2;

public class King extends Character {

	King(WeaponBehavior w) {
		weapon = w;
	}

	@Override
	void fight() {
		weapon.useWeapon();
	}
}