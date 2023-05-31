package org.gweep.springweb;

import org.apache.catalina.core.ApplicationContext;
import org.apache.naming.factory.BeanFactory;
import org.gweep.springweb.entity.Cat;
import org.gweep.springweb.entity.Dog;
import org.gweep.springweb.entity.Person;
import org.gweep.springweb.iface.Pet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebApplication.class, args);
        SpringWebApplication webApplication = new SpringWebApplication();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( "applicationContext2.xml","applicationContext3.xml");
        //Dog dog = context.getBean("dog", Dog.class);
       // Pet cat = context.getBean("cat", Pet.class);
//        List<Pet> pets = new ArrayList<>(Arrays.asList(dog, cat));
//        webApplication.say(pets);
        Person person = context.getBean("person", Person.class);
        // hardcode dependency
//        person.setPet(cat);
        person.callAllPet();
        // dependency injection (first created all object in container after use it)
       // Person personPetDog = context.getBean("personPetDog", Person.class);
        //Person personPetCat = context.getBean("personPetCat", Person.class);
        //Person personSetterPetDog = context.getBean("personSetterPetDog", Person.class);
       // personPetDog.callPet();
       // personPetCat.callPet();
       // personSetterPetDog.callPet();

//        Dog dog = context.getBean("dogWithParam", Dog.class);
//        Dog dog2 = context.getBean("dogWithParam", Dog.class);
//        int value = dog.init();
//        System.out.println(value);
        //Pet dog2 = context.getBean("dogWithParam", Dog.class);
        //((Dog)dog).bye();

//        Pet dog3 = context.getBean("dogWithParamSingle", Pet.class);
//        Pet dog4 = context.getBean("dogWithParamSingle", Pet.class);

//        ((Dog)dog).setName("Teddy");
        //System.out.println(dog);
//        System.out.println(dog2);
//        ((Dog)dog3).setName("Teddy123");
//        System.out.println(dog3);
//        System.out.println(dog4);

        context.close();
    }

//    public void say(List<Pet> pets){
//        for(Pet pet : pets) {
//            pet.say();
//        }
//    }

}
