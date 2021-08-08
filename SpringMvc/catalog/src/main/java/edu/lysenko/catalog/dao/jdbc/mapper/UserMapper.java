package edu.lysenko.catalog.dao.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import edu.lysenko.catalog.entity.Role;
import edu.lysenko.catalog.entity.User;
import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setPassword(rs.getString("password"));
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("name"));
		user.setSurname(rs.getString("surname"));
		user.setRole(Enum.valueOf(Role.class, rs.getString("role")));
		return user;
	}
}
