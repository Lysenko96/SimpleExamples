package edu.lysenko.catalog.dao.jdbc;

import java.sql.PreparedStatement;
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
import org.springframework.stereotype.Component;

import edu.lysenko.catalog.dao.TaskDao;
import edu.lysenko.catalog.entity.Task;
import edu.lysenko.catalog.entity.User;
import edu.lysenko.catalog.entity.UsersTasks;
import edu.lysenko.catalog.util.HibernateUtil;

@Component
public class JdbcTaskDao implements TaskDao {

	//private static final String ADD_TASK = "INSERT INTO tasks (tag, title) VALUES (?,?)";
	//private static final String GET_TASK = "SELECT * FROM tasks WHERE id=?";
	//private static final String GET_ALL_TASKS = "SELECT * FROM tasks";
	//private static final String UPDATE_TASK = "UPDATE tasks SET tag=?, title=? WHERE id=?";
	//private static final String DELETE_TASK = "DELETE FROM tasks WHERE id=?";
	private static final String GET_TASK_BY_TAG = "SELECT * FROM Task WHERE tag=?";
	private static final String ADD_TASK_USER_ID = "INSERT INTO User_Task(user_id, task_id) VALUES (?,?)";
	private static final String GET_ALL_TASK_ID_BY_USER_ID = "SELECT * FROM User_Task WHERE user_id=?";
	//private static final String DELETE_TASK_FROM_USERSTASKS_BY_TASK_ID = "DELETE FROM users_tasks WHERE task_id=?";
	private static final String SEARCH_TASK_BY_TAG = "SELECT * FROM Task WHERE tag LIKE '%' ? '%'";

	private Logger log = Logger.getLogger(JdbcTaskDao.class.getName());

	private JdbcTemplate jdbcTemplate;
	private BeanPropertyRowMapper<Task> taskMapper = BeanPropertyRowMapper.newInstance(Task.class);

	public JdbcTaskDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<UsersTasks> getAllTaskIdsByUserId(int id) {
		return jdbcTemplate.query(GET_ALL_TASK_ID_BY_USER_ID, BeanPropertyRowMapper.newInstance(UsersTasks.class), id);
	}

	public void deleteFromUsersTasksByTaskId(int id, int userId) {
		Transaction transaction = null;
		Task task = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			task = session.get(Task.class, id);
			user = session.get(User.class, userId);
			List<Integer> userNumberInList = new ArrayList<>();
			for (User aUser : task.getUsers()) {
				userNumberInList.add(task.getUsers().indexOf(aUser));
			}
			int index = task.getUsers().indexOf(user);
			System.out.println(userNumberInList.get(index));
			task.getUsers().remove((int) userNumberInList.get(index));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void add(int userId, int taskId) {
		jdbcTemplate.update(connection -> {
			PreparedStatement statement = connection.prepareStatement(ADD_TASK_USER_ID);
			statement.setInt(1, userId);
			statement.setInt(2, taskId);
			return statement;
		});
	}

	public List<Task> searchAllByTag(String keyword) {
		return jdbcTemplate.query(SEARCH_TASK_BY_TAG, taskMapper, keyword);
	}

	@Override
	public void save(Task task) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(task);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override
	public Task getById(int id) {
		Transaction transaction = null;
		Task task = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			task = session.get(Task.class, id);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return task;
	}

	@Override
	public List<Task> getAll() {
		Transaction transaction = null;
		List<Task> tasks = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Task> cq = cb.createQuery(Task.class);
			Root<Task> rootEntry = cq.from(Task.class);
			CriteriaQuery<Task> all = cq.select(rootEntry);
			TypedQuery<Task> allQuery = session.createQuery(all);
			tasks = allQuery.getResultList();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return tasks;
	}

	@Override
	public int update(Task task) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(task);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return task.getId();
	}

	@Override
	public void deleteById(int id) {
		Transaction transaction = null;
		Task task = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			task = session.get(Task.class, id);
			session.delete(task);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public Task findTaskByName(String tag) {
		try {
			return jdbcTemplate.queryForObject(GET_TASK_BY_TAG, taskMapper, tag);
		} catch (EmptyResultDataAccessException e) {
			log.info("No task in db");
		}
		return null;
	}

}
