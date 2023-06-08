package org.gweep.springpet.dao.jdbc;

import org.gweep.springpet.dao.PersonDao;
import org.gweep.springpet.model.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private static final String ADD_PERSON = "INSERT INTO person (firstname, lastname, login, password, year, email, address, phone, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_PERSON_BY_ID = "SELECT * FROM person WHERE id=?";
    private static final String GET_ALL_PERSONS = "SELECT * FROM person";
    private static final String UPDATE_PERSON = "UPDATE person SET firstname=?, lastname=?, login=?, password=?, year=?, email=?, address=?, phone=?, role=? WHERE id=?";
    private static final String DELETE_PERSON = "DELETE FROM person WHERE id=?";
    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Person person) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(ADD_PERSON, new String[]{"id"});
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
    public Person getById(long id) {
        return jdbcTemplate.queryForObject(GET_PERSON_BY_ID, new BeanPropertyRowMapper<>(Person.class), id);
    }

    @Override
    public List<Person> getAll() {
        return jdbcTemplate.query(GET_ALL_PERSONS, new BeanPropertyRowMapper<>(Person.class));
    }

    @Override
    public void update(Person person) {
        jdbcTemplate.update(UPDATE_PERSON, person.getFirstname(), person.getLastname(), person.getLogin(), person.getPassword(), person.getYear(), person.getEmail(),
                person.getAddress(), person.getPhone(), person.getRole().name(), person.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_PERSON, id);
    }
}
