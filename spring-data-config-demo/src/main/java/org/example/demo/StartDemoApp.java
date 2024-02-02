package org.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.demo.config.Config;
import org.example.demo.entity.Person;
import org.example.demo.repository.PersonRepository;
import org.example.demo.service.PersonService;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartDemoApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        PersonService personService = context.getBean(PersonService.class);
        System.out.println(personService.getClass());
//        EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
//        EntityManager em = emf.createEntityManager();
//        em.unwrap(Session.class).setDefaultReadOnly(true);
        PersonRepository personRepository = context.getBean(PersonRepository.class);
      //  System.out.println(em);
        personRepository.save(new Person());
        personService.doUpdateLastNameById(null,1L, "lastName12");
//        personRepository.findAll()
//                .forEach(System.out::println);
    }

}
