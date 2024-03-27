package net.pack.jdbcstyle;

import java.util.Arrays;
import java.util.List;

import net.pack.jdbcstyle.dao.PersonDao;
import net.pack.jdbcstyle.dao.jdbc.JdbcPersonDao;
import net.pack.jdbcstyle.entity.Person;
import net.pack.jdbcstyle.provider.Provider;

import static net.pack.jdbcstyle.entity.Sex.*;

public class Main {

	public static void main(String[] args) {
		Provider provider = new Provider();
//		provider.getConnection();
		PersonDao personDao = new JdbcPersonDao(provider);
		// personDao.add(new Person("name", "surname", FEMALE, "name@email.com", 1998,
		// "address", 9379992, "666"));
		List<Person> persons = Arrays.asList(
				new Person("name2", "surname2", FEMALE, "name2@email.com", 2000, "address2", 9379993, "777"),
				new Person("name3", "surname3", MALE, "name3@email.com", 1998, "address3", 9379994, "555"));
		//personDao.addBatch(persons);
		personDao.addBatch(persons);
		//System.out.println(personDao.getAll());
		provider.getDs().close();
	}
}