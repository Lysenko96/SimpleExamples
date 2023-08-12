package info.gweep.springtx;

import info.gweep.springtx.config.Config;
import info.gweep.springtx.entity.Car;
import info.gweep.springtx.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        CarService carService = context.getBean("carService", CarService.class);
        carService.add(new Car("Lexus"));
        carService.add(new Car("Nissan"));
        System.out.println(carService.getAll());


    }
}
