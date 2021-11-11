package net.gweep.templates2;

public abstract class Character {

	WeaponBehavior weapon;

	void fight() {
		weapon.useWeapon();
	}
	
	void setWeapon(WeaponBehavior w) {
		weapon = w;
	}
}
