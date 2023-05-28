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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //Pet dog = context.getBean("dog", Pet.class);
       // Pet cat = context.getBean("cat", Pet.class);
//        List<Pet> pets = new ArrayList<>(Arrays.asList(dog, cat));
//        webApplication.say(pets);
       // Person person = context.getBean("person", Person.class);
        // hardcode dependency
//        person.setPet(cat);
//        person.callPet();
        // dependency injection (first created all object in container after use it)
       // Person personPetDog = context.getBean("personPetDog", Person.class);
        Person personPetCat = context.getBean("personPetCat", Person.class);
        //Person personSetterPetDog = context.getBean("personSetterPetDog", Person.class);
       // personPetDog.callPet();
        personPetCat.callPet();
       // personSetterPetDog.callPet();

//        Pet dog = context.getBean("dogWithParam", Pet.class);
//        System.out.println(((Dog)dog).getName());
//        System.out.println(((Dog)dog).getAge());

        context.close();
    }

    public void say(List<Pet> pets){
        for(Pet pet : pets) {
            pet.say();
        }
    }

}
