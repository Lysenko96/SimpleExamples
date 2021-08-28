package hibernate.dao;

import java.util.List;

import hibernate.entity.Task;

public interface TaskDao {

	void save(Task task);

	Task getById(int id);

	List<Task> getAll();

	int update(Task task);

	void deleteById(int id);
}
