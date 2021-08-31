package edu.lysenko.catalog.dao.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import edu.lysenko.catalog.dao.UserDao;
import edu.lysenko.catalog.entity.User;

@Component
public class JdbcUserDao implements UserDao {

	private static final String ADD_USER = "INSERT INTO User (email, password, name, surname, role, register, lastLogin) VALUES (?,?,?,?,?,?,?)";
	private static final String GET_USER = "SELECT * FROM User WHERE id=?";
	private static final String GET_ALL_USERS = "SELECT * FROM User";
	private static final String UPDATE_USER = "UPDATE User SET email=?, password=?, name=?, surname=?, role=?, lastLogin=? WHERE id=?";
	private static final String DELETE_USER = "DELETE FROM User WHERE id=?";
	private static final String GET_USER_BY_EMAIL = "SELECT * FROM User WHERE email=?";

	private Logger log = Logger.getLogger(JdbcUserDao.class.getName());

	private PasswordEncoder encoder;
	private JdbcTemplate jdbcTemplate;
	private BeanPropertyRowMapper<User> userMapper = BeanPropertyRowMapper.newInstance(User.class);

	public JdbcUserDao(PasswordEncoder encoder, JdbcTemplate jdbcTemplate) {
		this.encoder = encoder;
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void add(User user) {
		final LocalDate register;
		if (user.getRegister() == null) {
			register = LocalDate.now();
		} else {
			register = user.getRegister();
		}
		try {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(connection -> {
				PreparedStatement statement = connection.prepareStatement(ADD_USER, new String[] { "id" });
				statement.setString(1, user.getEmail());
				statement.setString(2, encoder.encode(user.getPassword()));
				statement.setString(3, user.getName());
				statement.setString(4, user.getSurname());
				statement.setString(5, user.getRole().name());
				statement.setDate(6, Date.valueOf(register));
				statement.setTime(7, Time.valueOf(LocalTime.now()));
				return statement;
			}, keyHolder);
			user.setId(keyHolder.getKey().intValue());
		} catch (NullPointerException e) {
			log.info("null");
		}
	}

	@Override
	public User getById(int id) {
		return jdbcTemplate.queryForObject(GET_USER, userMapper, id);
	}

	@Override
	public List<User> getAll() {
		return jdbcTemplate.query(GET_ALL_USERS, userMapper);
	}

	@Override
	public int update(User user) {
		String encodePass = encoder.encode(user.getPassword());
		jdbcTemplate.update(UPDATE_USER, user.getEmail(), encodePass, user.getName(), user.getSurname(),
				user.getRole().name(), user.getLastLogin(), user.getId());
		return user.getId();
	}

	@Override
	public void deleteById(int id) {
		jdbcTemplate.update(DELETE_USER, id);
	}

	public User findUserByEmailPass(String email, String password) {
		User user = null;
		try {
			user = jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, userMapper, email);
			if (encoder.matches(password, user.getPassword())) {
				return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, userMapper, email);
			} else {
				user = null;
			}
		} catch (EmptyResultDataAccessException e) {
			log.info("No user in db");
		}
		return user;
	}

	public User findUserByEmail(String email) {
		try {
			return jdbcTemplate.queryForObject(GET_USER_BY_EMAIL, userMapper, email);
		} catch (EmptyResultDataAccessException e) {
			log.info("No user in db");
		}
		return null;
	}
}