package org.gweep.springpet.dao.jdbc;

import org.gweep.springpet.dao.PersonDao;
import org.gweep.springpet.model.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private static final String ADD_PERSON = "INSERT INTO person (firstname, lastname, year, address, email, phone, sex, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Person p) {
        jdbcTemplate.update(ADD_PERSON, p.getFirstname(), p.getLastname(), p.getYear(), p.getAddress(), p.getEmail(), p.getPhone(), p.getSex(), p.getRole());
    }

    @Override
    public Person getById(long id) {
        return null;
    }

    @Override
    public List<Person> getAll() {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void deleteById(long id) {

    }
}
