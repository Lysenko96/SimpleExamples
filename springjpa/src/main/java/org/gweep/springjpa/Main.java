package org.gweep.springjpa;

import org.gweep.springjpa.config.Config;
import org.gweep.springjpa.entity.Bike;
import org.gweep.springjpa.entity.Car;
import org.gweep.springjpa.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class Main {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);



        CarService carService = (CarService) context.getBean("carService");
        //carService.saveCarAndBike(new Car("Lamba32", "megacar1", 201.55), new Bike("Bike", "megabike", 300.55));
        carService.save(new Car("Lamba", "megacar1", 201.55));
        carService.save(new Car("SSC Tautara", "supercar", 223.334));
        carService.save(new Car("Lamba", "megacar4", 253.66));
        carService.save(new Car("Lamba", "megacar1", 266.36));
//        carService.save(new Car("Lamba", "megacar2", 155.55));
//        carService.save(new Car("Lamba", "megacar3", 191.73));


//        Car carDb = carService.findById(1L);
//        System.out.println(carDb);
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        carDb.setName("superdupercar");
//
//        carService.save(carDb);

       // System.out.println(carService.findAllByModel("SSC Tautara"));
//        System.out.println(carService.findAllByModelSort("Lamba", Sort.by("speed").descending()));
//        System.out.println(carService.findAllByModelPageable("Lamba",  PageRequest.of(0,5))); // page how many skip and size how many show
//        System.out.println(carService.findAllByModelPageable("Lamba",  PageRequest.of(2,2)));
//        System.out.println(carService.findAllByNameAndSpeedAfter("superdupercar", 111.333));
//        System.out.println(carService.findAllByModelAndSpeedEqualsNumber("Lamba", 255.66));

        context.close();
    }
}
