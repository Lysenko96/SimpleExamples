package hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import hibernate.dao.UserDao;
import hibernate.entity.Task;
import hibernate.entity.User;
import hibernate.util.HibernateUtil;

@Component
public class UserDaoImpl implements UserDao {
	
	//use in hibernate sql
	
//	public User findUserByEmailPass(String email, String password) {
//		User user = null;		
//		try {
//			user = jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, userMapper, email);
//			if (encoder.matches(password, user.getPassword())) {
//				return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, userMapper, email);
//			} else {
//				user = null;
//			}
//		} catch (EmptyResultDataAccessException e) {
//			log.info("No user in db");
//		}
//		return user;
//	}
//
//	public User findUserByEmail(String email) {
//		try {
//			return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, userMapper, email);
//		} catch (EmptyResultDataAccessException e) {
//			log.info("No user in db");
//		}
//		return null;
//	}

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
			System.out.println(taskNumberInList.get(index));
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
}
