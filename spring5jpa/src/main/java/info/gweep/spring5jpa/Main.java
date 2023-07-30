package info.gweep.spring5jpa;

import info.gweep.spring5jpa.config.JpaConfig;
import info.gweep.spring5jpa.service.EntityJpaService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
        EntityJpaService jpaService = context.getBean("entityJpaService", EntityJpaService.class);
        System.out.println(jpaService.getEntityManagerFactory());
        EntityManagerFactory em = context.getBean("entityManagerFactory", EntityManagerFactory.class);
        System.out.println(em);
    }
}

