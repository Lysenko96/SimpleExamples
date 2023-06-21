package org.example.springproject.dao.jdbc.mapper;

import org.example.springproject.model.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class PersonMapper implements RowMapper<Person> {


//    private PasswordEncoder encoder;
//
//    public PersonMapper(PasswordEncoder encoder) {
//        this.encoder = encoder;
//    }

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        Person person = new Person();
        person.setId(rs.getLong("id"));
        person.setName(rs.getString("name"));
        person.setSurname(rs.getString("surname"));
        person.setYear(rs.getInt("year"));
        person.setLogin(rs.getString("login"));
        person.setPassword(rs.getString("password"));
        person.setEmail(rs.getString("email"));
        person.setPhone(rs.getInt("phone"));
        person.setSum(rs.getInt("sum"));
        return person;
    }


}
