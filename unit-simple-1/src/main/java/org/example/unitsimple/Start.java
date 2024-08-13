package org.example.unitsimple;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class Start {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        context.getBean(EntityManagerFactory.class);
        context.close();
    }
}
