package edu.mytasks.lysenko;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MyTestBean testBean = context.getBean("testBean1", MyTestBean.class);
		System.out.println(testBean.getName());
		context.close();
	}
}
