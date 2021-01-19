package edu.tasks.springcore;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("edu.tasks.springcore")
@PropertySource("classpath:gameShop.properties")
public class SpringConfig {
	@Bean
	public Company company() {
		return new Company();
	}

	@Bean
	public GameShop gameShop() {
		return new GameShop(company());
	}
}
