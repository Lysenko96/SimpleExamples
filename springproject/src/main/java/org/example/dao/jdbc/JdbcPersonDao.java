package org.example.dao.jdbc;

import org.example.config.Config;
import org.example.dao.PersonDao;
import org.example.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class JdbcPersonDao implements PersonDao {

    private static final String ADD_PERSON = "INSERT INTO person (name, surname, year, login, password, email, phone) VALUES (?,?,?,?,?,?,?)";
    private static final String GET_ALL_PERSONS = "SELECT * FROM person";
    private static final String GET_PERSON_BY_ID = "SELECT * FROM person WHERE id=?";
    private static final String UPDATE_PERSON = "UPDATE person SET name=?, surname=?, year=?, login=?, password=?, email=?, phone=? WHERE id=?";
    private static final String DELETE_PERSON_BY_ID = "DELETE FROM person WHERE id=?";
    private BeanPropertyRowMapper<Person> mapper = new BeanPropertyRowMapper<>(Person.class);
    private JdbcTemplate jdbcTemplate;
    private PasswordEncoder encoder;

    public JdbcPersonDao(JdbcTemplate jdbcTemplate, ApplicationContext context) {
        this.jdbcTemplate = jdbcTemplate;
        Config config = context.getBean(Config.class);
        encoder = config.passwordEncoder();
    }

    @Override
    public void add(Person person) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(ADD_PERSON, new String[]{"id"});
            ps.setString(1, person.getName());
            ps.setString(2, person.getSurname());
            ps.setInt(3, person.getYear());
            ps.setString(4, person.getLogin());
            ps.setString(5, encoder.encode(person.getPassword()).split("}")[1]);
            ps.setString(6, person.getEmail());
            ps.setInt(7, person.getPhone());
            return ps;
        }, keyHolder);
        person.setId(keyHolder.getKey().longValue());
    }

    @Override
    public List<Person> getAll() {
        return jdbcTemplate.query(GET_ALL_PERSONS, mapper);
    }

    @Override
    public Person getById(long id) {
        return jdbcTemplate.queryForObject(GET_PERSON_BY_ID, mapper, id);
    }

    @Override
    public void update(Person person) {
        jdbcTemplate.update(UPDATE_PERSON, person.getName(), person.getSurname(), person.getYear(), person.getLogin(), encoder.encode(person.getPassword()).split("}")[1], person.getEmail(), person.getPhone(), person.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_PERSON_BY_ID, id);
    }
}
