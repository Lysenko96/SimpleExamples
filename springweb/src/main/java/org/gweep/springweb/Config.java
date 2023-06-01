package org.gweep.springweb;

import org.gweep.springweb.entity.Cat;
import org.gweep.springweb.entity.Dog;
import org.gweep.springweb.entity.Person;
import org.gweep.springweb.iface.Pet;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
//@ComponentScan("org.gweep.springweb.*")
public class Config {

    @Bean
    @Scope("singleton")
    public Pet cat(){
        //System.out.println("!");
        return new Cat();
    }

    @Bean
    @Scope("singleton")
    public Pet dog(){
        //System.out.println("!");
        return new Dog();
    }

    @Bean
    public Person personCat(){
        return new Person(cat());
    }

    @Bean
    public Person personDog(){
        return new Person(dog());
    }
}
