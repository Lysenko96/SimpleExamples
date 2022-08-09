package net.hairservice.dao.jdbc;

import net.hairservice.dao.DurationDao;
import net.hairservice.entities.Duration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class JdbcDurationDao implements DurationDao {

    private static final String ADD_DURATION = "INSERT INTO duration (day, \"fromTime\", \"toTime\") VALUES (?,?,?)";
    private static final String GET_DURATIONS = "SELECT * FROM duration";
    private static final String GET_DURATION_BY_ID = "SELECT * FROM duration WHERE id=?";
    private static final String UPDATE_DURATION = "UPDATE duration SET day=?, \"fromTime\"=?, \"toTime\"=? WHERE id=?";
    private static final String DELETE_DURATION = "DELETE FROM duration WHERE id=?";
    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<Duration> mapper = new BeanPropertyRowMapper<>(Duration.class);

    public JdbcDurationDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Duration duration) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(ADD_DURATION, new String[]{"id"});
            ps.setString(1, duration.getDay().name());
            ps.setTime(2, Time.valueOf(duration.getFromTime()));
            ps.setTime(3, Time.valueOf(duration.getToTime()));
            return ps;
        }, keyHolder);
        duration.setId(keyHolder.getKey().longValue());
    }

    @Override
    public List<Duration> getAll() {
        return jdbcTemplate.query(GET_DURATIONS, mapper);
    }

    @Override
    public Duration getById(long id) {
        return jdbcTemplate.queryForObject(GET_DURATION_BY_ID, mapper, id);
    }

    @Override
    public void update(Duration duration) {
        jdbcTemplate.update(UPDATE_DURATION, duration.getDay().name(), Time.valueOf(duration.getFromTime()), Time.valueOf(duration.getToTime()), duration.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_DURATION, id);
    }
}