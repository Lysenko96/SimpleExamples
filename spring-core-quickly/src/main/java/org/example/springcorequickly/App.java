package org.example.springcorequickly;


import org.example.springcorequickly.config.Config;
import org.example.springcorequickly.entity.Parrot;
import org.example.springcorequickly.entity.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        Parrot parrot = context.getBean(Parrot.class);
//        parrot.setName("Koko");
//        System.out.println(parrot);
        Person person = context.getBean(Person.class);
        person.setName("John");
//        person.getParrot().setName("Koko");
//        person.setParrot(parrot);
        System.out.println(person);
//        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

}
