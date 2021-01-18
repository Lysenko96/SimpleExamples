package edu.mytasks.lysenko;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Playable action = context.getBean("gameBeanAction", Playable.class);
		Playable strategy = context.getBean("gameBeanStrategy", Playable.class);
		Computer computer = new Computer(action);
		Computer computer1 = new Computer(strategy);
		System.out.println(computer.runGame());
		System.out.println(computer1.runGame());
		context.close();
	}
}
