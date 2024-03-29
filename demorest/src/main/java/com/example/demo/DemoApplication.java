package com.example.demo;

import com.example.demo.entity.Car;
import com.example.demo.service.Sound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import java.util.Arrays;

@SpringBootApplication
@ImportResource("classpath:root-config.xml")
public class DemoApplication {

    private static Sound sound; // @Qualifier
    private static Sound sound2; // @Primary @Profile("dog") or @Profile("fish") used application.properties
    private static Sound sound3; // if used @Primary and @Profile("fish") in two bean @Primary
                                 // one other @Profile("dog") = NoSuchBeanDefinitionException

//    if have default constructor spring boot use it, don't use constructor with args
//    public DemoApplication() {
//    }

    public DemoApplication(@Qualifier("catSound") Sound sound, Sound sound2) {
        DemoApplication.sound = sound;
        DemoApplication.sound2 = sound2;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        Car car = context.getBean("myCar", Car.class);
        Car car2 = context.getBean("car", Car.class);
        System.out.println(car);
        System.out.println(car2);
        //        Sound mySound = context.getBean("catSound", Sound.class);
//        System.out.println(mySound.sound());
//        System.out.println(sound.sound());
//        Sound mySound2 = context.getBean("fishSound", Sound.class);
//        System.out.println(mySound2.sound());
//        System.out.println(sound2.sound());
    }
//    @Bean
//    CommandLineRunner commandLineRunner(ApplicationContext context){
//        return args -> {
//            Arrays.stream(context.getBeanDefinitionNames()).sorted().forEach(System.out::println);
//        };
//    }

}
