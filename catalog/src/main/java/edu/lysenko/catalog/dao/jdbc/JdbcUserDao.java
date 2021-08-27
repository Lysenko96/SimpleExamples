package edu.lysenko.catalog.dao.jdbc;

//import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import edu.lysenko.catalog.dao.UserDao;
import edu.lysenko.catalog.entity.Task;
import edu.lysenko.catalog.entity.User;
import edu.lysenko.catalog.util.HibernateUtil;

@Component
public class JdbcUserDao implements UserDao {

	// private static final String ADD_USER = "INSERT INTO users (email, password,
	// name, surname, role) VALUES (?,?,?,?,?)";
	// private static final String GET_USER = "SELECT * FROM users WHERE id=?";
	// private static final String GET_ALL_USERS = "SELECT * FROM users";
	// private static final String UPDATE_USER = "UPDATE users SET email=?,
	// password=?, name=?, surname=?, role=? WHERE id=?";
	// private static final String DELETE_USER = "DELETE FROM users WHERE id=?";
	// private static final String DELETE_USER_FROM_USERSTASKS_BY_USER_ID = "DELETE
	// FROM users_tasks WHERE user_id=?";
	private static final String GET_USER_BY_EMAIL = "SELECT * FROM User WHERE email=?";

	private Logger log = Logger.getLogger(JdbcUserDao.class.getName());

	private PasswordEncoder encoder;
	private JdbcTemplate jdbcTemplate;
	private BeanPropertyRowMapper<User> userMapper = BeanPropertyRowMapper.newInstance(User.class);

	public JdbcUserDao(PasswordEncoder encoder, JdbcTemplate jdbcTemplate) {
		this.encoder = encoder;
		this.jdbcTemplate = jdbcTemplate;
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

	public User findUserByEmailPass(String email, String password) {
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, userMapper, email);
			if (encoder.matches(password, user.getPassword())) {
				return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, userMapper, email);
			} else {
				user = null;
			}
		} catch (EmptyResultDataAccessException e) {
			log.info("No user in db");
		}
		return user;
	}

	public User findUserByEmail(String email) {
		try {
			return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, userMapper, email);
		} catch (EmptyResultDataAccessException e) {
			log.info("No user in db");
		}
		return null;
	}
}