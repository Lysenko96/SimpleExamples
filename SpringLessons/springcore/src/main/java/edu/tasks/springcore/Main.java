package edu.tasks.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Creatable creatable = context.getBean("gameCompany", Creatable.class);

		GameShop gameShop = new GameShop(creatable);

		gameShop.playGame();

		context.close();

	}
}
