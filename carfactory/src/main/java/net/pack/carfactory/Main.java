package net.pack.carfactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.pack.carfactory.service.CarService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		CarService carService = context.getBean("carService", CarService.class);
		System.out.println(carService.getCars());
		((AnnotationConfigApplicationContext) context).close();
	}
}