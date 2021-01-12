package edu.tasks.lysenko.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import edu.tasks.lysenko.entity.Car;
import edu.tasks.lysenko.hibernate.HibernateUtil;

public class CarDao {

	private SessionFactory sessionFactory;

	public CarDao() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	public List<Car> getCars() {

		Session session = sessionFactory.openSession();
		session.get(Car.class, 1);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Car> criteriaQuery = builder.createQuery(Car.class);
		Root<Car> root = criteriaQuery.from(Car.class);
		criteriaQuery.select(root);
		Query query = session.createQuery(criteriaQuery);
		List<Car> cars = query.getResultList();
		session.close();
		return cars;
	}

}
