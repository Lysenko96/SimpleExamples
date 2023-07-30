package info.gweep.spring5jpa;

import info.gweep.spring5jpa.config.JpaConfig;
import info.gweep.spring5jpa.entity.Singer;
import info.gweep.spring5jpa.service.SingerServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
//        EntityJpaService jpaService = context.getBean("entityJpaService", EntityJpaService.class);
//        System.out.println(jpaService.getEntityManagerFactory());
//        System.out.println(jpaService.getEntityManager());
//        EntityManagerFactory em = context.getBean("entityManagerFactory", EntityManagerFactory.class);
//        System.out.println(em);
        SingerServiceImpl jpaSingerService = context.getBean("jpaSingerService", SingerServiceImpl.class);
        System.out.println(jpaSingerService);

        System.out.println(jpaSingerService.findAllWithAlbum());
        System.out.println(jpaSingerService.findAllByNativeQuery());
        System.out.println(jpaSingerService.findById(1L));
        System.out.println(jpaSingerService.save(new Singer("firstName", "lastName")));
        System.out.println(jpaSingerService.findAll());
        jpaSingerService.delete(jpaSingerService.findById(1L));
        System.out.println(jpaSingerService.findAll());
    }
}

