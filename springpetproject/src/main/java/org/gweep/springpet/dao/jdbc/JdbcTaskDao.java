package org.gweep.springpet.dao.jdbc;

import org.gweep.springpet.dao.TaskDao;
import org.gweep.springpet.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

public class JdbcTaskDao implements TaskDao {

    private static final String ADD_TASK = "INSERT INTO task (firstname, lastname, login, password, year, email, address, phone, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final JdbcTemplate jdbcTemplate;

    public JdbcTaskDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Task task) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(ADD_TASK, new String[]{"id"});
            ps.setString(1, person.getFirstname());
            ps.setString(2, person.getLastname());
            ps.setString(3, person.getLogin());
            ps.setString(4, person.getPassword());
            ps.setInt(5, person.getYear());
            ps.setString(6, person.getEmail());
            ps.setString(7, person.getAddress());
            ps.setString(8, person.getPhone());
            ps.setString(9, person.getRole().name());
            return ps;
        }, keyHolder);
        Number number = keyHolder.getKey();
        if (number != null) person.setId(number.longValue());
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
