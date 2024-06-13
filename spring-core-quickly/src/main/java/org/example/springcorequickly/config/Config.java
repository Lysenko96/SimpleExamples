package org.example.springcorequickly.config;

import org.example.springcorequickly.entity.Parrot;
import org.example.springcorequickly.entity.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("org.example.springcorequickly")
public class Config {

//    @Bean
//    @Scope("prototype")
//    Parrot parrot1(){
//        Parrot parrot1 = new Parrot();
//        parrot1.setName("Parrot 1");
//        return parrot1;
//    }

    @Bean
    @Scope("prototype")
    Parrot parrot2(){
        Parrot parrot2 = new Parrot();
        parrot2.setName("Parrot 2");
        return parrot2;
    }


//    @Bean
//    Person person(@Qualifier("parrot1") Parrot parrot){
//        Person person = new Person();
//        person.setParrot(parrot);
//        return person;
////        return new Person(parrot());
////        return new Person();
//    }

//    @Bean
//    Person person() {
//        return new Person();
//    }
}
