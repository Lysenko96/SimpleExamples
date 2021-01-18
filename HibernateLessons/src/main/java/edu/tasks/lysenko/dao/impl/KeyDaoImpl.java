package edu.tasks.lysenko.dao.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import edu.tasks.lysenko.dao.KeyDao;
import edu.tasks.lysenko.entity.Key;
import edu.tasks.lysenko.hibernate.HibernateUtil;

public class KeyDaoImpl implements KeyDao {

	@Override
	public void add(Key key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(key);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Key getById(int id) {
		return null;
	}

	@Override
	public List<Key> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.get(Key.class, 1);
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Key> criteriaQuery = builder.createQuery(Key.class);
		Root<Key> root = criteriaQuery.from(Key.class);
		criteriaQuery.select(root);
		Query query = session.createQuery(criteriaQuery);
		List<Key> keys = query.getResultList();
		return keys;
	}

	@Override
	public void update(Key key) {
		

	}

	@Override
	public void removeById(int id) {
		

	}

}
