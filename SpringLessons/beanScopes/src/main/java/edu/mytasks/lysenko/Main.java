package edu.mytasks.lysenko;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Computer compStrategy = context.getBean("computerStrategy", Computer.class);
		Computer compStrategy1 = context.getBean("computerStrategy", Computer.class);
		Computer compAction = context.getBean("computerAction", Computer.class);
		Computer compAction1 = context.getBean("computerAction", Computer.class);

		System.out.println(compAction);
		System.out.println(compAction1);

		System.out.println(compStrategy);
		System.out.println(compStrategy1);

		System.out.println(compStrategy.runGame());
		System.out.println(compAction.runGame());

		System.out.println("before change (scope=prototype)");

		System.out.println(compAction.getModelPC());
		System.out.println(compAction.getPricePC());

		System.out.println(compAction1.getModelPC());
		System.out.println(compAction1.getPricePC());

		// scope prototype for bean computerAction

		compAction1.setPricePC(12000);
		compAction1.setModelPC("HP");

		System.out.println("after change (scope=prototype)");

		System.out.println(compAction.getModelPC());
		System.out.println(compAction.getPricePC());

		System.out.println(compAction1.getModelPC());
		System.out.println(compAction1.getPricePC());

		System.out.println("before change (scope=singleton)");

		System.out.println(compStrategy.getModelPC());
		System.out.println(compStrategy.getPricePC());

		System.out.println(compStrategy1.getModelPC());
		System.out.println(compStrategy1.getPricePC());

		// scope singleton for bean computerStrategy

		compStrategy1.setPricePC(13000);
		compStrategy1.setModelPC("DELL");

		System.out.println("after change (scope=singleton)");

		System.out.println(compStrategy.getModelPC());
		System.out.println(compStrategy.getPricePC());

		System.out.println(compStrategy1.getModelPC());
		System.out.println(compStrategy1.getPricePC());

		// spring action in application*.xml
		// Computer comp = new Computer();
		// comp.setGenre(bean from application*.xml);

		context.close();
	}
}
