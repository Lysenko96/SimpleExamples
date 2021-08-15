package edu.lysenko.catalog.dao.jdbc;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import edu.lysenko.catalog.dao.TaskDao;
import edu.lysenko.catalog.dao.jdbc.mapper.TaskMapper;
import edu.lysenko.catalog.entity.Task;

@Component
public class JdbcTaskDao implements TaskDao {

	private static final String ADD_TASK = "INSERT INTO tasks (name, title) VALUES (?,?)";
	private static final String GET_TASK = "SELECT * FROM tasks WHERE id=?";
	private static final String GET_ALL_TASKS = "SELECT * FROM tasks";
	private static final String UPDATE_TASK = "UPDATE tasks SET name=?, title=? WHERE id=?";
	private static final String DELETE_TASK = "DELETE FROM tasks WHERE id=?";
	private static final String GET_TASK_BY_NAME = "SELECT * FROM tasks WHERE name=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private TaskMapper taskMapper;

	private Logger log = Logger.getLogger(JdbcTaskDao.class.getName());

	@Override
	public void add(Task task) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement statement = connection.prepareStatement(ADD_TASK, new String[] { "id" });
			statement.setString(1, task.getName());
			statement.setString(2, task.getTitle());
			return statement;
		}, keyHolder);
	}

	@Override
	public Task getById(int id) {
		return jdbcTemplate.queryForObject(GET_TASK, taskMapper, id);
	}

	@Override
	public List<Task> getAll() {
		return jdbcTemplate.query(GET_ALL_TASKS, taskMapper);
	}

	@Override
	public int update(Task task) {
		jdbcTemplate.update(UPDATE_TASK, task.getName(), task.getTitle(), task.getId());
		return task.getId();
	}

	@Override
	public void deleteById(int id) {
		jdbcTemplate.update(DELETE_TASK, id);
	}

	public Task findTaskByName(String name) {
		Task task = null;
		try {
			task = jdbcTemplate.queryForObject(GET_TASK_BY_NAME, taskMapper, name);
			return task;
		} catch (EmptyResultDataAccessException e) {
			log.info("No task in db");
			task = null;
		}
		return task;
	}

}
