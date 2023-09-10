package com.example.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication//(exclude = { DataSourceAutoConfiguration.class })
public class SpringShoppingCartApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringShoppingCartApplication.class, args);
    }

}
