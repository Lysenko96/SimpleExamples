package edu.mytasks.lysenko;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		Action action = context.getBean("gameBeanAction", Action.class);
		Action action1 = context.getBean("gameBeanAction", Action.class);

		// edu.mytasks.lysenko.Action@23e028a9
		// edu.mytasks.lysenko.Action@23e028a9

		System.out.println(action);
		System.out.println(action1);

		System.out.println(action.getGame());
		System.out.println(action1.getGame());

		// Strategy strategy = context.getBean("gameBeanStrategy", Strategy.class);
		// Strategy strategy1 = context.getBean("gameBeanStrategy", Strategy.class);

		System.out.println(context.getBean("gameBeanStrategy", Strategy.class).getGame());
		System.out.println(context.getBean("gameBeanStrategy", Strategy.class).getGame());

		context.close();
	}
}
