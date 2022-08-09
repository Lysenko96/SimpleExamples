package net.hairservice.dao.jdbc;

import net.hairservice.dao.DayScheduleDao;
import net.hairservice.entities.DaySchedule;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class JdbcScheduleDao implements DayScheduleDao {

    private static final String ADD_SCHEDULE = "INSERT INTO day_schedule (day, \"fromTime\", \"toTime\") VALUES (?,?,?)";
    private static final String GET_SCHEDULES = "SELECT * FROM day_schedule";
    private static final String GET_SCHEDULE_BY_ID = "SELECT * FROM day_schedule WHERE id=?";
    private static final String UPDATE_SCHEDULE = "UPDATE day_schedule SET day=?, \"fromTime\"=?, \"toTime\"=? WHERE id=?";
    private static final String DELETE_SCHEDULE = "DELETE FROM day_schedule WHERE id=?";
    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<DaySchedule> mapper = new BeanPropertyRowMapper<>(DaySchedule.class);

    public JdbcScheduleDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(DaySchedule schedule) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(ADD_SCHEDULE, new String[]{"id"});
            ps.setString(1, schedule.getDay().name());
            ps.setTime(2, Time.valueOf(schedule.getFromTime()));
            ps.setTime(3, Time.valueOf(schedule.getToTime()));
            return ps;
        }, keyHolder);
        schedule.setId(keyHolder.getKey().longValue());
    }

    @Override
    public List<DaySchedule> getAll() {
        return jdbcTemplate.query(GET_SCHEDULES, mapper);
    }

    @Override
    public DaySchedule getById(long id) {
        return jdbcTemplate.queryForObject(GET_SCHEDULE_BY_ID, mapper, id);
    }

    @Override
    public void update(DaySchedule schedule) {
        jdbcTemplate.update(UPDATE_SCHEDULE, schedule.getDay().name(), Time.valueOf(schedule.getFromTime()), Time.valueOf(schedule.getToTime()), schedule.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_SCHEDULE, id);
    }
}