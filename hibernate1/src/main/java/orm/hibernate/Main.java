package orm.hibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import orm.hibernate.dao.CarDao;
import orm.hibernate.dao.impl.CarDaoImpl;
import orm.hibernate.dao.impl.DriverDaoImpl;
import orm.hibernate.entity.Car;
import orm.hibernate.entity.Driver;
import orm.hibernate.util.HibernateUtil;

public class Main {

	public static void main(String[] args) {
//		CarDaoImpl carDao = new CarDaoImpl();
//		DriverDaoImpl driverDao = new DriverDaoImpl();
//		Car car = new Car(1, "Sauber Mercedes", 405);
//		Car car1 = new Car(2, "Porsche", 385);
//		List<Car> setCars = new ArrayList<>();
//		List<Car> setCars1 = new ArrayList<>();
//		 setCars.add(car);
//		setCars.add(car1);
//		setCars1.add(car1);
//		List<Driver> setDrivers = new ArrayList<>();
//		List<Driver> setDrivers1 = new ArrayList<>();
//		Driver driver = new Driver(1, "Michael", "Schumacher", 2435, setCars1);
//		Driver driver1 = new Driver(2, "Mark Alan", "Webber", 3213, setCars);
//		setDrivers.add(driver);
//		setDrivers1.add(driver1);
//		car.setDrivers(setDrivers);
//		car1.setDrivers(setDrivers1);
//		carDao.save(car);
//		carDao.save(car1);
//		driverDao.save(driver);
//		driverDao.save(driver1);
		// System.out.println(driverDao.getAll());
		// System.out.println(carDao.getAll());
		// System.out.println(carDao.getAll().get(0).getDrivers());
		// System.out.println(carDao.getAll().get(1).getDrivers());
		// carDao.deleteFromCarDriverByCarId(1);
		// carDao.deleteById(2);
		// driverDao.deleteById(1);
//		driverDao.deleteById(driver1.getId());
		// System.out.println(driverDao.getAll());
		// System.out.println(carDao.getAll());
		// System.out.println(carDao.getAll().get(0).getDrivers());
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			transaction = session.beginTransaction();
//			Query query = session.createQuery("from Car_Driver");
//			List list = query.getResultList();
//			System.out.println(list);
//			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
		// driverDao.deleteById(1);

		// -------
		// find for id index in set
		//
		// --------
		Transaction transaction = null;
		Driver driver = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			// index driver from 1
			driver = session.get(Driver.class, 1);
			// index car from 0
			// driver.getCars().remove(0);
			List<Integer> indexes = new ArrayList<>();
			for (Car c : driver.getCars()) {
				indexes.add(driver.getCars().indexOf(c));
			}
			System.out.println(indexes.get(0));
			//
			driver.getCars().remove((int) indexes.get(0));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		// driverDao.deleteById(1);
		// System.out.println(driverDao.getById(2).getCars());
		// System.out.println(carDao.getById(1).getDrivers());
	}
}
