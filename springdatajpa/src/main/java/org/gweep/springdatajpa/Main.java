package org.gweep.springdatajpa;

import org.gweep.springdatajpa.entity.Car;
import org.gweep.springdatajpa.entity.CarDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Car.class)
                .addAnnotatedClass(CarDetails.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        CarDetails carDetails = new CarDetails("SCC Tautara", null);
       // CarDetails carDetails2 = new CarDetails("SCC Tautara2", null);
        session.persist(carDetails);
        //session.persist(carDetails2);
        Car car = new Car("SCC", "Tautara", 502.233, carDetails);
       // Car car2 = new Car("SCC2", "Tautara2", 493.233, carDetails2);
        //System.out.println(car);
        session.persist(car);
       // carDetails.setCar(car);

        Car myCar = session.createQuery("FROM Car WHERE id = :id", Car.class)
                .setParameter("id", 1L)
                .getSingleResult();
        System.out.println(myCar);

        List<Car> myCars = session.createQuery("FROM Car", Car.class)
                .getResultList();
        System.out.println(myCars);

        Car carDb = session.get(Car.class, car.getId());
       // CarDetails carDetailsDb = session.get(CarDetails.class, carDetails.getId());
        System.out.println(carDb.getCarDetails());
        System.out.println(carDb.getCarDetails().getCar());
       // System.out.println(carDetailsDb.getCar());

        //carDetails2.setCar(car2);
        //session.merge(new Car(1L, "SCC1", "Tautara1", 502.23555, carDetails));
        //session.persist(car2);
      //  carDetails2.setCar(car2);
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
        session.getTransaction().commit();

        Session session2 = sessionFactory.getCurrentSession();
        session2.beginTransaction();
        Car car3 = new Car("SCC", "Tautara", 502.233, null);
        session2.persist(car3);
        car3.setName("SCCNameCar");
        session2.getTransaction().commit();

        Session session3 = sessionFactory.getCurrentSession();
        session3.beginTransaction();
        System.out.println(session3.get(Car.class, 1L));
        System.out.println(session3.get(Car.class, 1L));
        session3.getTransaction().commit();

        Session session4 = sessionFactory.getCurrentSession();
        session4.beginTransaction();
        System.out.println(session4.get(Car.class, 1L));
        System.out.println(session4.get(Car.class, 1L));
        session4.getTransaction().commit();


        sessionFactory.close();


    }

}
