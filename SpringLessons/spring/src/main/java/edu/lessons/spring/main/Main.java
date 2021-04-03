package edu.lessons.spring.main;

//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

		// AnnotationConfigApplicationContext context = new
		// AnnotationConfigApplicationContext(Config.class);

		BookBean book = context.getBean("bookBean", BookBean.class);

		System.out.println(book.toString());

//		book.setName("myName");
//
//		book.setAuthor("myAuthor");
		

		BookRepo repo = context.getBean("bookRepo", BookRepo.class);
		
		//BookRepo repo1 = new BookRepo();
		//repo1.setBook(book);
		//System.out.println(repo1.toString()); 
		
		System.out.println(repo.toString());

		context.close();
	}
}
