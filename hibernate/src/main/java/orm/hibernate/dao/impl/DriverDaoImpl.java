package orm.hibernate.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.Transaction;

import orm.hibernate.dao.DriverDao;
import orm.hibernate.entity.Driver;
import orm.hibernate.util.HibernateUtil;

public class DriverDaoImpl implements DriverDao {

	@Override
	// @Transactional
	public void save(Driver driver) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(driver);
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
	public Driver getById(int id) {
		Transaction transaction = null;
		Driver driver = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			driver = session.get(Driver.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return driver;
	}

	@Override
	@Transactional
	public List<Driver> getAll() {
		Transaction transaction = null;
		List<Driver> drivers = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Driver> cq = cb.createQuery(Driver.class);
			Root<Driver> rootEntry = cq.from(Driver.class);
			CriteriaQuery<Driver> all = cq.select(rootEntry);
			TypedQuery<Driver> allQuery = session.createQuery(all);
			drivers = allQuery.getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return drivers;
	}

	@Override
	// @Transactional
	public void update(Driver driver) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(driver);
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
	public void deleteById(int id) {
		Transaction transaction = null;
		Driver driver = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			driver = session.get(Driver.class, id);
			session.delete(driver);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
