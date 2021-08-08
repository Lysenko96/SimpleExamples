package edu.lysenko.catalog.dao.jdbc;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import edu.lysenko.catalog.dao.UserDao;
import edu.lysenko.catalog.dao.jdbc.mapper.UserMapper;
import edu.lysenko.catalog.entity.User;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class JdbcUserDao implements UserDao {

	private static final String ADD_USER = "INSERT INTO users (email, password, name, surname, role) VALUES (?,?,?,?,?)";
	private static final String GET_USER = "SELECT * FROM users WHERE id=?";
	private static final String GET_ALL_USERS = "SELECT * FROM users";
	private static final String UPDATE_USER = "UPDATE users SET email=?, password=?, name=?, surname=?, role=? WHERE id=?";
	private static final String DELETE_USER = "DELETE FROM users WHERE id=?";

	
	private JdbcTemplate jdbcTemplate;
	private UserMapper userMapper;

	public JdbcUserDao(JdbcTemplate jdbcTemplate, UserMapper userMapper) {
		this.jdbcTemplate = jdbcTemplate;
		this.userMapper = userMapper;
	}

	@Override
	public void add(User user) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(connection -> {
			PreparedStatement statement = connection.prepareStatement(ADD_USER, new String[] { "id" });
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getName());
			statement.setString(4, user.getSurname());
			statement.setString(5, user.getRole().name());
			return statement;
		}, keyHolder);
		user.setId(keyHolder.getKey().intValue());
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
		jdbcTemplate.update(UPDATE_USER, user.getEmail(), user.getPassword(), user.getName(), user.getSurname(),
				user.getRole().name(), user.getId());
		return user.getId();
	}

	@Override
	public void deleteById(int id) {
		jdbcTemplate.update(DELETE_USER, id);
	}

}
