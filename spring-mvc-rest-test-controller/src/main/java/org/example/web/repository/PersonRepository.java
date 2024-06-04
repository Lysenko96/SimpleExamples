package org.example.web.repository;

import lombok.RequiredArgsConstructor;
import org.example.web.entity.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class PersonRepository {

//    private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//    private static JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

    private final JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        jdbcTemplate.query("SELECT * FROM PERSONS", rs -> {
            Person person = new Person();
            person.setFirstName(rs.getString("FIRST_NAME"));
            person.setLastName(rs.getString("LAST_NAME"));
            person.setSalary(rs.getInt("SALARY"));
            persons.add(person);
        });
        return persons;
    }

    public void save(Person person) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO PERSONS(FIRST_NAME, LAST_NAME, SALARY) VALUES (?,?,?)", new String[]{"ID"});
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setInt(3, person.getSalary());
            return ps;
        }, keyHolder);
        person.setId(Objects.requireNonNull(keyHolder.getKey()).intValue());
    }

//    public static void main(String[] args) {
//        PersonRepository repository = context.getBean(PersonRepository.class);
//        repository.save(new Person("John", "Doe", 100));
//    }


}
