package com.example.demo;

import com.example.demo.util.Provider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataPerformanceDemoApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(SpringDataPerformanceDemoApplication.class, args);
       // Provider provider = context.getBean(Provider.class);
        //provider.getFromDatabaseJdbc();
    }

}
