package edu.tasks.lysenko.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import edu.tasks.lysenko.dao.CarDao;
import edu.tasks.lysenko.entity.Car;
import edu.tasks.lysenko.hibernate.HibernateUtil;

public class CarDaoImpl implements CarDao {

	private static final String ADD_CAR = "SELECT * cars WHERE car_id=?";

	@Override
	public void add(Car car) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(car);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Car getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createNativeQuery(ADD_CAR).addEntity(Car.class);
		query.setParameter(1, id);
		Car car = (Car) query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return car;
	}

	@Override
	public List<Car> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.get(Car.class, 1);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Car> criteriaQuery = builder.createQuery(Car.class);
		Root<Car> root = criteriaQuery.from(Car.class);
		criteriaQuery.select(root);
		Query query = session.createQuery(criteriaQuery);
		List<Car> cars = query.getResultList();
		return cars;
	}

	@Override
	public void update(Car car) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(car);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void remove(Car car) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.remove(car);
		session.getTransaction();
		session.close();
	}
}
