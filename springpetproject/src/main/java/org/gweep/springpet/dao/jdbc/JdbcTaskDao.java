package org.gweep.springpet.dao.jdbc;

import org.gweep.springpet.dao.TaskDao;
import org.gweep.springpet.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

public class JdbcTaskDao implements TaskDao {

    private static final String ADD_TASK = "INSERT INTO task (name, description, status) VALUES (?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public JdbcTaskDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Task task) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(ADD_TASK, new String[]{"id"});
            ps.setString(1, task.getName());
            ps.setString(2, task.getDescription());
            ps.setString(3, task.getStatus().name());
            return ps;
        }, keyHolder);
        Number number = keyHolder.getKey();
        if (number != null) task.setId(number.longValue());
    }

    @Override
    public Task getById(long id) {
        return null;
    }

    @Override
    public List<Task> getAll() {
        return null;
    }

    @Override
    public void update(Task task) {

    }

    @Override
    public void deleteById(long id) {

    }
}
