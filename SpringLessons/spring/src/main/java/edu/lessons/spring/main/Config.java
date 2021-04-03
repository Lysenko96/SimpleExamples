package edu.lessons.spring.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("edu.lessons.spring.main")
@PropertySource("classpath:book.properties")
public class Config {

//	@Bean
//	public BookBean bookBean() {
//		return new BookBean();
//	}
//
//	@Bean
//	public BookRepo bookRepo() {
//		return new BookRepo(bookBean());
//	}

}
