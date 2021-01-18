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

	private static final String ADD_KEY = "SELECT * FROM key WHERE key_id=?";

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
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createNativeQuery(ADD_KEY).addEntity(Key.class);
		query.setParameter("key_id", id);
		Key key = (Key) query.getSingleResult();
		session.getTransaction().commit();
		session.close();
		return key;
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
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(key);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void remove(Key key) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.remove(key);
		session.getTransaction().commit();
		session.close();
	}

}
