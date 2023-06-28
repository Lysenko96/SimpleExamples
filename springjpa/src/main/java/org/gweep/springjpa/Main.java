package org.gweep.springjpa;

import org.gweep.springjpa.config.Config;
import org.gweep.springjpa.entity.Car;
import org.gweep.springjpa.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        CarService carService = (CarService) context.getBean("carService");
        carService.save(new Car("model", "name", 223.334));

        System.out.println(carService.findAllByModel("model"));
        System.out.println(carService.findAllByNameAndSpeedAfter("name", 223.334));

        context.close();
    }
}
