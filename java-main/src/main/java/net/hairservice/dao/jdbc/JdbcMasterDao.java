package net.hairservice.dao.jdbc;

import net.hairservice.dao.MasterDao;
import net.hairservice.entities.Master;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class JdbcMasterDao implements MasterDao {

    private static final String ADD_MASTER = "INSERT INTO master (photo, name, surname, phone, email, role, login, password) VALUES (?,?,?,?,?,?,?,?)";
    private static final String GET_MASTERS = "SELECT * FROM master";
    private static final String GET_MASTER_BY_ID = "SELECT * FROM master WHERE id=?";
    private static final String UPDATE_MASTER = "UPDATE master SET photo=?, name=?, surname=?, phone=?, email=?, role=?, login=?, password=? WHERE id=?";
    private static final String DELETE_MASTER = "DELETE FROM master WHERE id=?";
    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<Master> mapper = new BeanPropertyRowMapper<>(Master.class);

    public JdbcMasterDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Master master) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(ADD_MASTER, new String[]{"id"});
            ps.setBlob(1, master.getPhoto());
            ps.setString(2, master.getName());
            ps.setString(3, master.getSurname());
            ps.setInt(4, master.getPhone());
            ps.setString(5, master.getEmail());
            ps.setString(6, master.getRole().name());
            ps.setString(7, master.getLogin());
            ps.setString(8, master.getPassword());
            return ps;
        }, keyHolder);
        master.setId(keyHolder.getKey().longValue());
    }

    @Override
    public List<Master> getAll() {
        return jdbcTemplate.query(GET_MASTERS, mapper);
    }

    @Override
    public Master getById(long id) {
        return jdbcTemplate.queryForObject(GET_MASTER_BY_ID, mapper, id);
    }

    @Override
    public void update(Master master) {
        jdbcTemplate.update(UPDATE_MASTER, master.getPhoto(), master.getName(), master.getSurname(), master.getPhone(), master.getEmail(), master.getRole().name(), master.getLogin(), master.getPassword(), master.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_MASTER, id);
    }
}