package edu.mytasks.lysenko;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Computer compStrategy = context.getBean("computerStrategy", Computer.class);
		Computer compAction = context.getBean("computerAction", Computer.class);
		System.out.println(compStrategy.runGame());
		System.out.println(compAction.runGame());
		System.out.println(compAction.getModelPC());
		System.out.println(compAction.getPricePC());
		System.out.println(compStrategy.getModelPC());
		System.out.println(compStrategy.getPricePC());
		// spring action in application*.xml
		// Computer comp = new Computer();
		// comp.setGenre(bean from application*.xml);

		context.close();
	}
}
