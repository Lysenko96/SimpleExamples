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
		return null;
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
		
	}

	@Override
	public void removeById(int id) {
		
	}

}
