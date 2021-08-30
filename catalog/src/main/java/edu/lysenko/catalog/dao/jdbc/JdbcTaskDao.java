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
import org.springframework.stereotype.Component;

import edu.lysenko.catalog.dao.TaskDao;
import edu.lysenko.catalog.entity.Task;
import edu.lysenko.catalog.entity.User;
import edu.lysenko.catalog.service.UserService;
import edu.lysenko.catalog.util.HibernateUtil;

@Component
public class JdbcTaskDao implements TaskDao {

	public List<Integer> getAllTaskIdsByUserId(int id) {
		Transaction transaction = null;
		List<Integer> taskIds = new ArrayList<>();
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from user where id = :id");
			query.setParameter("id", id);
			user = (User) query.getResultList().get(0);
			for (Task aTask : user.getTasks()) {
				taskIds.add(aTask.getId());
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return taskIds;
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
			task.getUsers().remove((int) userNumberInList.get(index));
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void addFromUsersTasksByTaskId(int id, int userId) {
		Transaction transaction = null;
		Task task = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			task = session.get(Task.class, id);
			user = session.get(User.class, userId);
			task.getUsers().add(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public List<Task> searchAllByTag(String keyword) {
		Transaction transaction = null;
		List<Task> tasks = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from task where keyword =: LIKE '%' keyword '%'");
			query.setParameter("keyword", keyword);
			tasks = (List<Task>) query.getResultList();
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
	public void save(Task task) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
//			List<Task> tasks = new ArrayList<>();
//			for (Integer index : getAllTaskIdsByUserId(UserService.getId())) {
//				Task aTask = getById(index);
//				tasks.add(aTask);
//			}
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
		Transaction transaction = null;
		Task task = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query = session.createQuery("from task where tag = :tag");
			query.setParameter("tag", tag);
			task = (Task) query.getResultList().get(0);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return task;
	}

}
