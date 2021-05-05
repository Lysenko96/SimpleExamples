package edu.lysenko.iface2;

import edu.lysenko.iface.IFaceable;

public class Main implements IFaceable {

	int p = 3;
	
	static void u(Monster b) {
		b.menace();
	}

	static void v(DangerousMonster d) {
		d.menace();
		d.destroy();
	}

	static void w(VampireLethal l) {
		l.kill();
	}

	public static void main(String[] args) {
		DangerousMonster zilla = new DragonZilla();
		u(zilla);
		v(zilla);
		VampireLethal vlad = new VeryBadVampire();
		u(vlad);
		v(vlad);
		w(vlad);
		System.out.println(Main.count);
	}
}

abstract class Monster {
	abstract void menace();
}

abstract class DangerousMonster extends Monster {
	abstract void destroy();
}

//abstract class Lethal {
//	abstract void kill();
//}

class DragonZilla extends DangerousMonster {

	@Override
	public void menace() {
		System.out.println("DragonZilla menace");
	}

	@Override
	public void destroy() {
		System.out.println("DragonZilla destroy");
	}
}

abstract class Vampire extends DangerousMonster {
	abstract void drinkBlood();
}

abstract class VampireLethal extends Vampire {
	abstract void kill();
}

class VeryBadVampire extends VampireLethal {

	@Override
	public void destroy() {
		System.out.println("VeryBadVampire destroy");
	}

	@Override
	public void menace() {
		System.out.println("VeryBadVampire menace");
	}

	@Override
	public void kill() {
		System.out.println("VeryBadVampire kill");
	}

	@Override
	public void drinkBlood() {
		System.out.println("VeryBadVampire drinkBlood");
	}
}
