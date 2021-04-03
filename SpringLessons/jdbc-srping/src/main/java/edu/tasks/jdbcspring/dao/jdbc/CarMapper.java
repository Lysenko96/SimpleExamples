package edu.tasks.jdbcspring.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import edu.tasks.jdbcspring.entity.Car;

public class CarMapper implements RowMapper<Car> {

	@Override
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
		Car car = new Car();
		car.setId(rs.getInt("id"));
		car.setModel(rs.getString("model"));
		car.setSpeed(rs.getInt("speed"));
		return car;
	}

}
