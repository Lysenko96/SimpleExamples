package edu.lysenko.catalog.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import edu.lysenko.catalog.entity.Task;

@Component
public class TaskMapper implements RowMapper<Task> {

	@Override
	public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
		Task task = new Task();
		task.setId(rs.getInt("id"));
		task.setName(rs.getString("name"));
		task.setTitle(rs.getString("title"));
		return task;
	}
}