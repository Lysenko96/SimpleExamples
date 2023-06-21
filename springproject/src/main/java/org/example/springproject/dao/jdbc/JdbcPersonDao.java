package org.example.springproject.dao.jdbc;

import org.example.springproject.config.Config;
import org.example.springproject.dao.PersonDao;
import org.example.springproject.dao.jdbc.mapper.PersonMapper;
import org.example.springproject.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;
@Repository
public class JdbcPersonDao implements PersonDao {

    private static final String ADD_PERSON = "INSERT INTO person (name, surname, year, login, password, email, phone, sum) VALUES (?,?,?,?,?,?,?,?)";
    //private static final String GET_ALL_PERSONS = "SELECT *, sum(person) FROM person GROUP BY person.id";
    private static final String GET_ALL_PERSONS = "SELECT * FROM person";
    private static final String GET_PERSON_BY_ID = "SELECT * FROM person WHERE id=?";
    private static final String UPDATE_PERSON = "UPDATE person SET name=?, surname=?, year=?, login=?, password=?, email=?, phone=? WHERE id=?";
    private static final String DELETE_PERSON_BY_ID = "DELETE FROM person WHERE id=?";
    private BeanPropertyRowMapper<Person> mapper = new BeanPropertyRowMapper<>(Person.class);
    private JdbcTemplate jdbcTemplate;
    private PasswordEncoder encoder;
    private PersonMapper personMapper;
//
    public JdbcPersonDao(JdbcTemplate jdbcTemplate, PasswordEncoder encoder, PersonMapper personMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.encoder = encoder;
        this.personMapper = personMapper;
    }
//
//    public JdbcPersonDao(JdbcTemplate jdbcTemplate, PasswordEncoder encoder) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.encoder = encoder;
//    }

    @Override
    public void add(Person person) {
        //KeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcTemplate.update(conn -> {
//            PreparedStatement ps = conn.prepareStatement(ADD_PERSON, new String[]{"id"});
//            ps.setString(1, person.getName());
//            ps.setString(2, person.getSurname());
//            ps.setInt(3, person.getYear());
//            ps.setString(4, person.getLogin());
//            ps.setString(5, encoder.encode(person.getPassword()));
//            ps.setString(6, person.getEmail());
//            ps.setInt(7, person.getPhone());
//            //ps.setInt(8, person.getSum() != null ? person.getSum() : 0);
//            ps.setObject(8, person.getSum());
//            return ps;
//        }, keyHolder);
//        person.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        //jdbcTemplate.update(ADD_PERSON);
         person.setId(new SimpleJdbcInsert(jdbcTemplate)
                 .withTableName("person")
                 .usingGeneratedKeyColumns("id")
                 .executeAndReturnKey(new BeanPropertySqlParameterSource(person)).longValue());
        }

    @Override
    // public List<Person> getAll() {
    //    return jdbcTemplate.query(GET_ALL_PERSONS, mapper);
    //  }
    public List<Person> getAll() {
        return jdbcTemplate.query(GET_ALL_PERSONS, personMapper);
    }

    @Override
    public Person getById(long id) {
        return jdbcTemplate.queryForObject(GET_PERSON_BY_ID, mapper, id);
    }

    //    @Override
//    public void update(Person person) {
//        jdbcTemplate.update(UPDATE_PERSON, person.getName(), person.getSurname(), person.getYear(), person.getLogin(), encoder.encode(person.getPassword()), person.getEmail(), person.getPhone(), person.getId());
//    }
    @Override
    public void update(Person person) {
        jdbcTemplate.update(UPDATE_PERSON, person.getName(), person.getSurname(), person.getYear(), person.getLogin(), encoder.encode(person.getPassword()), person.getEmail(), person.getPhone(), person.getId());
    }

    @Override
    public void deleteById(long id) {
        jdbcTemplate.update(DELETE_PERSON_BY_ID, id);
    }

}
