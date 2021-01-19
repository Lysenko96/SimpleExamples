package edu.tasks.springcore;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("edu.tasks.springcore")
@PropertySource("classpath:gameShop.properties")
public class SpringConfig {

}
