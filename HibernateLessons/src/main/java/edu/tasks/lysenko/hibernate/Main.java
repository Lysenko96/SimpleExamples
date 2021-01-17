package edu.tasks.lysenko.hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import edu.tasks.lysenko.dao.ClassDao;
import edu.tasks.lysenko.entity.Car;
import edu.tasks.lysenko.entity.Driver;
import edu.tasks.lysenko.entity.Key;

public class Main {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		System.out.println(session);
		List<Car> cars = new ArrayList<>();
		List<Driver> drivers = new ArrayList<>();
		List<Key> keys = new ArrayList<>();
		session.beginTransaction();
		Car car = new Car("Sauber Mercedes", 405);
		Car car1 = new Car("Ferrari", 385);
		Set<Car> setCars = new HashSet<>();
		setCars.add(car);
		setCars.add(car1);
		Key key = new Key("Sauber Mercedes key");
		Driver driver = new Driver("Michael", "Schumacher", 1, key, setCars);
		session.save(car);
		session.save(car1);
		session.save(key);
		session.save(driver);
		for (Object object : new ClassDao().getList(session, Car.class)) {
			cars.add((Car) object);
		}
		for (Object object : new ClassDao().getList(session, Key.class)) {
			keys.add((Key) object);
		}
		session.getTransaction().commit();
		for (Object object : new ClassDao().getList(session, Driver.class)) {
			drivers.add((Driver) object);
		}
		session.close();
		System.out.println(drivers);
		System.out.println(keys);
		System.out.println(cars);

	}
}
