package org.gweep.springdatajpa;

import org.gweep.springdatajpa.entity.Car;
import org.gweep.springdatajpa.entity.CarDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Car.class).addAnnotatedClass(CarDetails.class).buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
//        CarDetails carDetails = new CarDetails(1L, "SCC Tautara");
//        Car car = new Car("SCC", "Tautara", 502.233, carDetails);
//        Car car2 = new Car("SCC2", "Tautara2", 493.233, carDetails);
//        System.out.println(car);
//        session.persist(car);
//        session.persist(car2);
//        System.out.println(car);
//        session.merge(new Car(1L, "SCC1", "Tautara1", 502.23555, carDetails));
        Car carDb = session.get(Car.class, 1L);
        System.out.println(carDb);
        System.out.println(carDb.getCarDetails());
        System.out.println(carDb.getCarDetails().getCar());
//        System.out.println("hql: " + session.createQuery("FROM  Car where id=2", Car.class).getSingleResult()); // set class name, not table name in sql query
//        System.out.println("hql wildcard: " + session.createQuery("FROM  Car where id= :id", Car.class).setParameter("id", 2).getSingleResult());
//        System.out.println("get: " + carDb);
//        System.out.println(session.createQuery("FROM Car", Car.class).getResultList());
//        session.remove(carDb);
//        System.out.println(session.createQuery("FROM Car", Car.class).getResultList());
        session.getTransaction().commit();


        sessionFactory.close();
    }

}
