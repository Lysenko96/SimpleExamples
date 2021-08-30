package edu.lysenko.catalog.dao.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import edu.lysenko.catalog.dao.UserDao;
import edu.lysenko.catalog.entity.Task;
import edu.lysenko.catalog.entity.User;
import edu.lysenko.catalog.util.HibernateUtil;

@Component
public class JdbcUserDao implements UserDao {

	private PasswordEncoder encoder;

	public JdbcUserDao(PasswordEncoder encoder) {
		this.encoder = encoder;
	}

	public void deleteFromUsersTasksByUserId(int id, int taskId) {
		Transaction transaction = null;
		Task task = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
			task = session.get(Task.class, taskId);
			List<Integer> taskNumberInList = new ArrayList<>();
			for (Task aTask : user.getTasks()) {
				taskNumberInList.add(user.getTasks().indexOf(aTask));
			}
			int index = user.getTasks().indexOf(task);
			user.getTasks().remove((int) taskNumberInList.get(index));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public void save(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String pass = user.getPassword();
			String ecodePass = encoder.encode(pass);
			user.setPassword(ecodePass);
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public User getById(int id) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAll() {
		Transaction transaction = null;
		List<User> users = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<User> cq = cb.createQuery(User.class);
			Root<User> rootEntry = cq.from(User.class);
			CriteriaQuery<User> all = cq.select(rootEntry);
			TypedQuery<User> allQuery = session.createQuery(all);
			users = allQuery.getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int update(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String pass = user.getPassword();
			String ecodePass = encoder.encode(pass);
			user.setPassword(ecodePass);
			session.update(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user.getId();
	}

	@Override
	public void deleteById(int id) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public User findUserByEmail(String email) {
		Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from user where email = :email");
			query.setParameter("email", email);
			user = (User) query.getResultList().get(0);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}
}