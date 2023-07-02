package org.gweep.springjpa;

import org.gweep.springjpa.config.Config;
import org.gweep.springjpa.entity.Bike;
import org.gweep.springjpa.entity.Car;
import org.gweep.springjpa.entity.Driver;
import org.gweep.springjpa.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);



        CarService carService = (CarService) context.getBean("carService");
//              carService.saveCarAndBike(new Car("Lamba32", "megacar1", 201.55), new Bike("Bike", "megabike", 300.55));
        Car car = new Car("Lamba", "megacar1", 201.55);
        Car car2 = new Car("Lamba2", "megacar2", 333.55);
        //System.out.println(car);
        carService.save(car);
        carService.save(car2);
        Driver driver = new Driver( "name", "surname");
        Driver driver2 = new Driver( "name2", "surname2");
        carService.saveDriver(driver);
        carService.saveDriver(driver2);

        carService.driverUseCar(driver.getId(), car.getId());
        carService.driverUseCar(driver.getId(), car2.getId());
        carService.driverUseCar(driver2.getId(), car.getId());

        System.out.println(carService.findDriverById(driver.getId()));
        System.out.println(carService.findById(car.getId()).getDrivers());
        System.out.println(carService.findById(car2.getId()).getDrivers());
        System.out.println(carService.findDriverById(driver2.getId()));

        //carService.driverUseCar(driver.getId(), car2.getId());
//        carService.save(new Car("SSC Tautara", "supercar", 223.334));
//        carService.save(new Car("Lamba", "megacar4", 253.66));
//        carService.save(new Car("Lamba", "megacar1", 266.36));
//        carService.save(new Car("Lamba", "megacar2", 155.55));
//        carService.save(new Car("Lamba", "megacar3", 191.73));


        //System.out.println(car);
//        Car carDb = carService.findById(1L);
//       System.out.println(carDb);

//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        //carDb.setName("superdupercar");

//        carService.updateById(carDb.getId());
//        System.out.println(carDb);

        //System.out.println(carService.findAllByModel("SSC Tautara"));
//        List<Car> cars = carService.findAllByModelSort("Lamba", Sort.by("speed"));
//        System.out.println(cars);
//        System.out.println(carService.findAllByModelPageable("Lamba",  PageRequest.of(0,5))); // page how many skip and size how many show
//       System.out.println(carService.findAllByModelPageable("Lamba",  PageRequest.of(1,2)));
//        System.out.println(carService.findAllByNameAndSpeedAfter("superdupercar", 111.333));
//        System.out.println(carService.findAllByModelAndSpeedEqualsNumber("Lamba", 255.66));

        context.close();
    }
}
