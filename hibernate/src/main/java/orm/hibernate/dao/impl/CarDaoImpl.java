package orm.hibernate.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import orm.hibernate.dao.CarDao;
import orm.hibernate.entity.Car;
import orm.hibernate.util.HibernateUtil;

public class CarDaoImpl implements CarDao {

	// private static String DELETE_DRIVER_BY_ID_FROM_CAR_DRIVER = "DELETE FROM
	// car_driver WHERE driver_id=?";

	public void deleteFromCarDriverByCarId(int id) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			 Query query = session.createQuery("from car");
			 List<Car> cars = query.getResultList();
			System.out.println(cars);
//			query.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	// @Transactional
	public void save(Car car) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(car);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	// @Transactional
	public Car getById(int id) {
		Transaction transaction = null;
		Car car = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			car = session.get(Car.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return car;
	}

	@Override
	// @Transactional
	public List<Car> getAll() {
		Transaction transaction = null;
		List<Car> cars = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Car> cq = cb.createQuery(Car.class);
			Root<Car> rootEntry = cq.from(Car.class);
			CriteriaQuery<Car> all = cq.select(rootEntry);
			TypedQuery<Car> allQuery = session.createQuery(all);
			cars = allQuery.getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cars;
	}

	@Override
	public void update(Car car) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(car);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int id) {
		Transaction transaction = null;
		Car car = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			car = session.get(Car.class, id);
			session.delete(car);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
