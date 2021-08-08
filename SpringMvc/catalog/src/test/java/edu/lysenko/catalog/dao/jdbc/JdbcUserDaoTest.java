package edu.lysenko.catalog.dao.jdbc;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.jdbc.JdbcTestUtils;

import edu.lysenko.catalog.config.ConfigTest;
import edu.lysenko.catalog.dao.UserDao;
import edu.lysenko.catalog.dao.jdbc.mapper.UserMapper;
import edu.lysenko.catalog.entity.Role;
import edu.lysenko.catalog.entity.User;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ConfigTest.class })
@WebAppConfiguration
@Sql("/users-data.sql")
class JdbcUserDaoTest {

	private User user;
	private UserDao userDao;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@BeforeEach
	void setUp() {
		userDao = new JdbcUserDao(jdbcTemplate, new UserMapper());
		assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "users"));
		user = new User(1, "user@gmail.com", "passwd", "name", "surname", Role.USER);
	}

	@Test
	void addTest() {
		user = new User(1, "user@gmail.com1", "passwd", "name", "surname", Role.USER);
		userDao.add(user);
		assertEquals(2, user.getId());
		assertEquals(2, JdbcTestUtils.countRowsInTable(jdbcTemplate, "users"));
	}

	@Test
	void getByIdTest() {
		User actual = userDao.getById(1);
		assertEquals(user, actual);
		assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "users"));
	}

	@Test
	void getAllTest() {
		List<User> expected = Arrays.asList(user);
		assertEquals(expected, userDao.getAll());
		assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "users"));
	}

	@Test
	void updateTest() {
		user = new User(1, "user@gmail.com5", "passwd", "name", "surname", Role.USER);
		int id = userDao.update(user);
		assertEquals(1, id);
		assertEquals(1, JdbcTestUtils.countRowsInTable(jdbcTemplate, "users"));
	}

	@Test
	void deleteByIdTest() {
		userDao.deleteById(1);
		assertEquals(0, JdbcTestUtils.countRowsInTable(jdbcTemplate, "users"));
	}
}
