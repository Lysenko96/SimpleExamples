package net.pack.weapon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.pack.weapon.aspect.Fire;
import net.pack.weapon.aspect.Reload;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Weapon {

	private String name;
	protected Fire fire;
	protected Reload reload;

	public Weapon getWeaponByName(String name) {
		Weapon weapon = null;
		if (name.toLowerCase().contains("automatic")) {
			weapon = new Ak47(name);
		} else if (name.toLowerCase().contains("sword")) {
			weapon = new Sword(name);
		}
		return weapon;
	}
	
	public void performFire() {
		fire.fire();
	}

	public void performReload() {
		reload.reload();
	}
}