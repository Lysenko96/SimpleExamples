package edu.lysenko.catalog.dao.jdbc;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.lysenko.catalog.dao.UserDao;
import edu.lysenko.catalog.dao.jdbc.mapper.UserMapper;
import edu.lysenko.catalog.entity.User;

public class JdbcUserDao implements UserDao {

	private static final String ADD_USER = "INSERT INTO users (email, password, name, surname, role) VALUES (?,?,?,?,?)";
	private static final String GET_USER = "SELECT * FROM users WHERE id=?";
	private static final String GET_ALL_USERS = "SELECT * FROM users";
	private static final String UPDATE_USER = "UPDATE users SET email=?, password=?, name=?, surname=?, role=? WHERE id=?";
	private static final String DELETE_USER = "DELETE FROM users WHERE id=?";
	private static final String GET_USER_BY_EMAIL = "SELECT * FROM users WHERE email=?";

	private PasswordEncoder encoder = new BCryptPasswordEncoder(12);

	private Logger log = Logger.getLogger(JdbcUserDao.class.getName());

	private JdbcTemplate jdbcTemplate;

	public JdbcUserDao(DataSource dataSource) {
		DatabasePopulatorUtils.execute(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")), dataSource);
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void add(User user) {
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(connection -> {
				PreparedStatement statement = connection.prepareStatement(ADD_USER, new String[] { "id" });
				statement.setString(1, user.getEmail());
				statement.setString(2, encoder.encode(user.getPasswd()));
				statement.setString(3, user.getName());
				statement.setString(4, user.getSurname());
				statement.setString(5, user.getRole().name());
				return statement;
			}, keyHolder);
			user.setId(keyHolder.getKey().intValue());
		} catch (NullPointerException e) {
			log.info("null");
		}
	}

	@Override
	public User getById(int id) {
		return jdbcTemplate.queryForObject(GET_USER, new UserMapper(), id);
	}

	@Override
	public List<User> getAll() {
		return jdbcTemplate.query(GET_ALL_USERS, new UserMapper());
	}

	@Override
	public int update(User user) {
		String encodePass = encoder.encode(user.getPasswd());
		jdbcTemplate.update(UPDATE_USER, user.getEmail(), encodePass, user.getName(), user.getSurname(),
				user.getRole().name(), user.getId());
		return user.getId();
	}

	@Override
	public void deleteById(int id) {
		jdbcTemplate.update(DELETE_USER, id);
	}

	public User findUserByEmailPass(String email, String password) {
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, new UserMapper(), email);
			if (encoder.matches(password, user.getPasswd())) {
				return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, new UserMapper(), email);
			} else {
				user = null;
			}
		} catch (EmptyResultDataAccessException e) {
			log.info("No user in db");
		}
		return user;
	}

	public User findUserByEmail(String email) {
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, new UserMapper(), email);
			return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, new UserMapper(), email);
		} catch (EmptyResultDataAccessException e) {
			log.info("No user in db");
		}
		return user;
	}

}
