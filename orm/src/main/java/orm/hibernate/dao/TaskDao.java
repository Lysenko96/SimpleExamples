package orm.hibernate.dao;

import java.util.List;

import orm.hibernate.entity.Task;

public interface TaskDao {

	void save(Task task);

	Task getById(int id);

	List<Task> getAll();

	int update(Task task);

	void deleteById(int id);
}
