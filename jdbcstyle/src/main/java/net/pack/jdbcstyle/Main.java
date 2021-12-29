package net.pack.jdbcstyle;

import net.pack.jdbcstyle.dao.PersonDao;
import net.pack.jdbcstyle.dao.jdbc.JdbcPersonDao;
import net.pack.jdbcstyle.entity.Person;
import net.pack.jdbcstyle.provider.Provider;

import static net.pack.jdbcstyle.entity.Sex.*;

public class Main {

	public static void main(String[] args) {
		Provider provider = new Provider();
		provider.getConnection();
//		PersonDao personDao = new JdbcPersonDao(provider);
//		personDao.add(new Person("name", "surname", FEMALE, "name@email.com", 18, "address", 9379992, "666"));
		//System.out.println(personDao.getAll());
	}
}