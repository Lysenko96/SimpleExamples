package net.gweep.templates.decorator;

import net.gweep.templates.decorator.Beverage.Size;
import net.gweep.templates.decorator.beverage.DarkRoast;
import net.gweep.templates.decorator.beverage.DarkRoastPlus;
import net.gweep.templates.decorator.beverage.Espresso;
import net.gweep.templates.decorator.beverage.HouseBlend;
import net.gweep.templates.decorator.condiment.Mocha;
import net.gweep.templates.decorator.condiment.Soy;
import net.gweep.templates.decorator.condiment.Whip;

public class Main {

	public static void main(String[] args) {

		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverage2 = new DarkRoast();
		beverage2 = new Soy(beverage2);
		System.out.println(beverage2.cost());
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());
		beverage2 = new Mocha(beverage2, Size.VENTI);
		System.out.println(beverage2.cost());
		//beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

		Beverage beverage3 = new HouseBlend();
		beverage3 = new Soy(beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
		beverage3 = new Mocha(beverage3, Size.VENTI);
		beverage3 = new Whip(beverage3);
		System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
	
	    BeveragePlus bPlus = new DarkRoastPlus();
	    System.out.println(bPlus.cost());
	    bPlus.setHasMocha(true);
	    System.out.println(bPlus.cost());
	}
}