package net.pack.weapon;

import java.util.ArrayList;
import java.util.List;

import net.pack.weapon.aspect.Fire;
import net.pack.weapon.aspect.Reload;
import net.pack.weapon.entity.Ak47;
import net.pack.weapon.entity.Bow;
import net.pack.weapon.entity.Weapon;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		Weapon weapon = new Weapon();
		List<Weapon> weapons = new ArrayList<>(
				List.of(weapon.getWeaponByName("automatic Ak-47"), weapon.getWeaponByName("sword Excalibur")));
		main.methodDone(weapons);
		weapons.remove(0);
		weapons.add(new Bow("Bow", new Bow(), null));
		System.out.println();
		main.methodDone(weapons);
		weapons.get(1).setFire(new Ak47());
		System.out.println();
		main.methodDone(weapons);
	}

	void methodDone(List<Weapon> weapons) {
		for (Weapon weapon : weapons) {
			if (weapon instanceof Fire && weapon instanceof Reload) {
				weapon.performFire();
				weapon.performReload();
			} else if (weapon instanceof Fire) {
				weapon.performFire();
			} else if (weapon instanceof Reload) {
				weapon.performReload();
			}
		}
	}
}