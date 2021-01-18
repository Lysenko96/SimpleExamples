package edu.tasks.lysenko.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import edu.tasks.lysenko.dao.DriverDao;
import edu.tasks.lysenko.entity.Driver;
import edu.tasks.lysenko.hibernate.HibernateUtil;

public class DriverDaoImpl implements DriverDao {

	private static final String ADD_DRIVER = "SELECT * FROM driver WHERE driver_id=?";

	@Override
	public void add(Driver driver) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(driver);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Driver getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createNativeQuery(ADD_DRIVER).addEntity(Driver.class);
		query.setParameter("driver_id", id);
		Driver driver = (Driver) query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return driver;
	}

	@Override
	public List<Driver> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.get(Driver.class, 1);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Driver> criteriaQuery = builder.createQuery(Driver.class);
		Root<Driver> root = criteriaQuery.from(Driver.class);
		criteriaQuery.select(root);
		Query query = session.createQuery(criteriaQuery);
		List<Driver> drivers = query.getResultList();
		return drivers;
	}

	@Override
	public void update(Driver driver) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(driver);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void remove(Driver driver) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.remove(driver);
		session.getTransaction().commit();
		session.close();
	}

}
