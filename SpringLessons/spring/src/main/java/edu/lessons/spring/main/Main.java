package edu.lessons.spring.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

		BookBean book = context.getBean("bookBean", BookBean.class);

		book.setName("myName");

		book.setAuthor("myAuthor");

		BookRepo repo = context.getBean("bookRepo", BookRepo.class);

		System.out.println(repo.toString());

		context.close();
	}
}
