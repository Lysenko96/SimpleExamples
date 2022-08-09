package net.hairservice.dao.jdbc;

import net.hairservice.dao.ClientDao;
import net.hairservice.entities.Client;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class JdbcClientDao implements ClientDao {

    private static final String ADD_CLIENT = "INSERT INTO client (name, surname, phone, email, role, login, password, hairstyle) VALUES (?,?,?,?,?,?,?,?)";
    private static final String GET_CLIENTS = "SELECT * FROM client";
    private static final String GET_CLIENT_BY_ID = "SELECT * FROM client WHERE id=?";
    private static final String UPDATE_CLIENT = "UPDATE client SET name=?, surname=?, phone=?, email=?, role=?, login=?, password=?, hairstyle=? WHERE id=?";
    private static final String DELETE_CLIENT = "DELETE FROM client WHERE id=?";
    private final JdbcTemplate jdbcTemplate;
    private final BeanPropertyRowMapper<Client> mapper = new BeanPropertyRowMapper<>(Client.class);

    public JdbcClientDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Client client) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(ADD_CLIENT, new String[]{"id"});
            ps.setString(1, client.getName());
            ps.setString(2, client.getSurname());
            ps.setInt(3, client.getPhone());
            ps.setString(4, client.getEmail());
            ps.setString(5, client.getRole().name());
            ps.setString(6, client.getLogin());
            ps.setString(7, client.getPassword());
            ps.setString(8, client.getHairstyle().name());
            return ps;
        }, keyHolder);
        client.setId(keyHolder.getKey().longValue());
    }

    @Override
    public List<Client> getAll() {
        return jdbcTemplate.query(GET_CLIENTS, mapper);
    }

    @Override
    public Client getById(long id) {
        return jdbcTemplate.queryForObject(GET_CLIENT_BY_ID, mapper, id);
    }

    @Override
    public void update(Client client) {
        jdbcTemplate.update(UPDATE_CLIENT, client.getName(), client.getSurname(), client.getPhone(), client.getEmail(), client.getRole().name(), client.getLogin(), client.getPassword(), client.getHairstyle().name(), client.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_CLIENT, id);
    }
}