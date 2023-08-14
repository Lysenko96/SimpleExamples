package info.gweep.spring5mvc;

import info.gweep.spring5mvc.config.Config;
import info.gweep.spring5mvc.service.SingerServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SingerServiceImpl singerService = context.getBean("singerServiceImpl", SingerServiceImpl.class);
        System.out.println(singerService.findAll());
    }
}
