package net.gweep.templates2;

public class Main {

	public static void main(String[] args) {
		Character king = new King(new KnifeBehavior());
		Character knight = new Knight(new SwordBehavior());
		Character queen = new Queen(new BowAndArrowBehavior());
		Character troll = new Troll(new AxeBehavior());
		System.out.println(king.getClass().getSimpleName());
		king.fight();
		System.out.println(knight.getClass().getSimpleName());
		knight.fight();
		System.out.println(queen.getClass().getSimpleName());
		queen.fight();
		System.out.println(troll.getClass().getSimpleName());
		troll.fight();
		System.out.println();
		king.setWeapon(new SwordBehavior());
		knight.setWeapon(new AxeBehavior());
		troll.setWeapon(new KnifeBehavior());
		System.out.println(king.getClass().getSimpleName());
		king.fight();
		System.out.println(knight.getClass().getSimpleName());
		knight.fight();
		System.out.println(queen.getClass().getSimpleName());
		queen.fight();
		System.out.println(troll.getClass().getSimpleName());
		troll.fight();
	}
}
