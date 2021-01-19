package edu.tasks.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		Creatable creatable = context.getBean("gameCompany", Creatable.class);

		GameShop gameShop = new GameShop(creatable);

		// before create bean game=null
		System.out.println(gameShop.getGame());

		GameShop shop = context.getBean("gameShop", GameShop.class);
		// after create bean - Warcraft
		System.out.println(gameShop.playGame(shop.getGame()));

		context.close();

	}
}
