package info.gweep.spring5jpa;

import info.gweep.spring5jpa.config.JpaConfig;
import info.gweep.spring5jpa.entity.Singer;
import info.gweep.spring5jpa.entity.SingerAudit;
import info.gweep.spring5jpa.service.AlbumServiceImpl;
import info.gweep.spring5jpa.service.SingerAuditService;
import info.gweep.spring5jpa.service.SingerAuditServiceImpl;
import info.gweep.spring5jpa.service.SingerServiceImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
//        EntityJpaService jpaService = context.getBean("entityJpaService", EntityJpaService.class);
//        System.out.println(jpaService.getEntityManagerFactory());
//        System.out.println(jpaService.getEntityManager());
//        EntityManagerFactory em = context.getBean("entityManagerFactory", EntityManagerFactory.class);
//        System.out.println(em);
        SingerServiceImpl jpaSingerService = context.getBean("jpaSingerService", SingerServiceImpl.class);
        AlbumServiceImpl jpaAlbumService = context.getBean("springJpaAlbumService", AlbumServiceImpl.class);
        SingerAuditServiceImpl singerAuditService = context.getBean("singerAuditService", SingerAuditServiceImpl.class);
//        System.out.println(jpaSingerService);
//
        System.out.println(jpaSingerService.findAllWithAlbum());
//        System.out.println(jpaSingerService.findAllByNativeQuery());
//        System.out.println(jpaSingerService.findById(1L));
//        System.out.println(jpaSingerService.save(new Singer("firstName", "lastName")));
//        System.out.println(jpaSingerService.findAll());
//        jpaSingerService.delete(jpaSingerService.findById(1L));
//        System.out.println(jpaSingerService.findAll());
//        System.out.println(jpaSingerService.findAllJpa());
//        System.out.println(jpaSingerService.findByFirstName("John"));
//        System.out.println(jpaSingerService.findByFirstNameAndLastName("John", "Butler"));
//        System.out.println(jpaAlbumService.findByTitle("The"));
//        System.out.println(jpaAlbumService.findAllBySinger(jpaSingerService.findById(1L)));
       //SingerAudit singerAudit = new SingerAudit(1L, "firstName", "lastName");
//       SingerAudit singerAudit = new SingerAudit( "firstName", "lastName");
//        System.out.println(singerAuditService.save(singerAudit));
//        System.out.println(singerAuditService.findAll());
//        singerAudit = singerAuditService.findById(1L);
//        singerAudit.setFirstName("myName");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(singerAuditService.save(singerAudit));

    }
}

