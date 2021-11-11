package net.gweep.templates2;

public class Queen extends Character {

	Queen(WeaponBehavior w){
		weapon = w;
	}

	@Override
	void fight() {
		weapon.useWeapon();
	}
}