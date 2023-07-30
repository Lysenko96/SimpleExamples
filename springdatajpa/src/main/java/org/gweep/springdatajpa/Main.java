package org.gweep.springdatajpa;

import org.gweep.springdatajpa.config.Config;
import org.gweep.springdatajpa.entity.Car;
import org.gweep.springdatajpa.entity.CarDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class Main {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().
                addAnnotatedClass(Car.class).
                addAnnotatedClass(CarDetails.class).
                buildSessionFactory();
        System.out.println(sessionFactory);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        SessionFactory sessionFactory1 = context.getBean("sessionFactory", SessionFactory.class);
        System.out.println(sessionFactory1);

        Session session = sessionFactory1.getCurrentSession();

        session.beginTransaction();
        CarDetails carDetails = new CarDetails("SCC Tautara", null);
        session.persist(carDetails);
        Car car = new Car("SCC", "Tautara", 502.233, carDetails);
        session.persist(car);
        session.getTransaction().commit();

        session.close();

//        Session session = sessionFactory.getCurrentSession();
//
//        session.beginTransaction();
//        CarDetails carDetails = new CarDetails("SCC Tautara", null);
//        CarDetails carDetails2 = new CarDetails("SCC Tautara2", null);
//        session.persist(carDetails);
//        session.persist(carDetails2);
//        Car car = new Car("SCC", "Tautara", 502.233, carDetails);
//        Car car2 = new Car("SCC2", "Tautara2", 493.233, carDetails2);
//        System.out.println(car);
<<<<<<< HEAD
        session.persist(car);
        System.out.println("CacheManager: " + CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("car"));
//        CacheManager.ALL_CACHE_MANAGERS.remove(CacheManager.ALL_CACHE_MANAGERS.get(0));
//        System.out.println("size: " + CacheManager.ALL_CACHE_MANAGERS.size());
=======
//        session.persist(car);
>>>>>>> 2a2b57caae49f08a6a94db07a217f6b4be346230
//        carDetails.setCar(car);
//        //carDetails2.setCar(car2);
//        //session.merge(new Car(1L, "SCC1", "Tautara1", 502.23555, carDetails));
//        session.persist(car2);
//        carDetails2.setCar(car2);
//        System.out.println(car);
//        //session.merge(new Car(1L, "SCC1", "Tautara1", 502.23555, carDetails));
//        Car carDb = session.get(Car.class, 1L);
//        Car carDb2 = session.get(Car.class, 2L);
//        System.out.println(carDb);
//        System.out.println(carDb.getCarDetails());
//        System.out.println(carDb.getCarDetails().getCar());
//        System.out.println(carDb2);
//        System.out.println(carDb2.getCarDetails());
//        System.out.println(carDb2.getCarDetails().getCar());
////        System.out.println("hql: " + session.createQuery("FROM  Car where id=2", Car.class).getSingleResult()); // set class name, not table name in sql query
////        System.out.println("hql wildcard: " + session.createQuery("FROM  Car where id= :id", Car.class).setParameter("id", 2).getSingleResult());
////        System.out.println("get: " + carDb);
////        System.out.println(session.createQuery("FROM Car", Car.class).getResultList());
////        session.remove(carDb);
////        System.out.println(session.createQuery("FROM Car", Car.class).getResultList());
<<<<<<< HEAD
        session.getTransaction().commit();
        //int size = CacheManager.ALL_CACHE_MANAGERS.get(0);

        System.out.println("###############");
        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();
        //Car carDbOne = session2.get(Car.class, 1L);
        Car carDbOne = session2.get(Car.class, 1L);
        Car carDbTwo = session2.get(Car.class, 1L);
        System.out.println(carDbOne);
        System.out.println(carDbTwo);
        session2.getTransaction().commit();

        Session session3 = sessionFactory.getCurrentSession();

        session3.beginTransaction();
        Car carDbThree = session3.get(Car.class, 1L);
        System.out.println(carDbThree);
//        Car car1 = new Car("SCC", "Tautara", 502.233, null);
//        session3.persist(car1);
//        car1.setSpeed(443.4);
        session3.getTransaction().commit();
        System.out.println("###############");
        sessionFactory.close();
=======
//        session.getTransaction().commit();

//        Session session3 = sessionFactory.getCurrentSession();
//
//        session3.beginTransaction();
//        Car car = new Car("SCC", "Tautara", 502.233, null);
//        session3.persist(car);
//        car.setSpeed(443.4);
//        session3.getTransaction().commit();
//
//        sessionFactory.close();
>>>>>>> 2a2b57caae49f08a6a94db07a217f6b4be346230

    }

}
