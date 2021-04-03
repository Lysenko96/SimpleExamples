package edu.tasks.jdbcspring.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//import edu.tasks.jdbcspring.connection.ConnectionProvider;
import edu.tasks.jdbcspring.dao.CarDao;
import edu.tasks.jdbcspring.entity.Car;

public class JdbcCarDao implements CarDao {

	public static final String CAR_ADD = "INSERT INTO cars (model, speed) VALUES (?,?)";
	public static final String CAR_GET = "SELECT * FROM cars WHERE id=?";
	public static final String CAR_GET_ALL = "SELECT * FROM cars";
	public static final String CAR_UPDATE = "UPDATE cars SET model=?, speed=? WHERE id=?";
	public static final String CAR_DELETE = "DELETE FROM cars WHERE id=?";

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcCarDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// private ConnectionProvider provider;
//
//	public JdbcCarDao(ConnectionProvider provider) {
//		this.provider = provider;
//	}

//	@Override
//	public void add(Car car) {
//		try (Connection connection = provider.getConnection();
//				PreparedStatement statement = connection.prepareStatement(CAR_ADD, Statement.RETURN_GENERATED_KEYS);) {
//			statement.setString(1, car.getModel());
//			statement.setInt(2, car.getSpeed());
//			statement.executeUpdate();
//			ResultSet key = statement.getGeneratedKeys();
//			if (key.next()) {
//				car.setId(key.getInt("id"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public void add(Car car) {
		jdbcTemplate.update(CAR_ADD, car.getModel(), car.getSpeed());
	}

//	@Override
//	public Car getById(int id) {
//		try (Connection connection = provider.getConnection();
//				PreparedStatement statement = connection.prepareStatement(CAR_GET);) {
//			statement.setInt(1, id);
//			ResultSet resultSet = statement.executeQuery();
//			if (resultSet.next()) {
//				Car car = new Car();
//				car.setId(resultSet.getInt("id"));
//				car.setModel(resultSet.getString("model"));
//				car.setSpeed(resultSet.getInt("speed"));
//				return car;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

//	@Override
//	public List<Car> getAll() {
//		List<Car> cars = new ArrayList<>();
//		try (Connection connection = provider.getConnection(); Statement statement = connection.createStatement();) {
//			ResultSet resultSet = statement.executeQuery(CAR_GET_ALL);
//			while (resultSet.next()) {
//				Car car = new Car();
//				car.setId(resultSet.getInt("id"));
//				car.setModel(resultSet.getString("model"));
//				car.setSpeed(resultSet.getInt("speed"));
//				cars.add(car);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return cars;
//	}

	@Override
	public List<Car> getAll() {
		return jdbcTemplate.query(CAR_GET_ALL, new BeanPropertyRowMapper<>(Car.class));
	}

	@Override
	public Car getById(int id) {
		return jdbcTemplate.query(CAR_GET, new Object[] { id }, new BeanPropertyRowMapper<>(Car.class)).stream()
				.findAny().orElse(null);
	}

	@Override
	public void update(Car car) {
		jdbcTemplate.update(CAR_UPDATE, car.getModel(), car.getSpeed(), car.getId());
	}

	@Override
	public void deleteById(int id) {
		jdbcTemplate.update(CAR_DELETE, id);
	}

//	@Override
//	public void update(Car car) {
//		try (Connection connection = provider.getConnection();
//				PreparedStatement statement = connection.prepareStatement(CAR_UPDATE);) {
//			statement.setString(1, car.getModel());
//			statement.setInt(2, car.getSpeed());
//			statement.setInt(3, car.getId());
//			statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

//	@Override
//	public void deleteById(int id) {
//
//		try (Connection connection = provider.getConnection();
//				PreparedStatement statement = connection.prepareStatement(CAR_DELETE);) {
//			statement.setInt(1, id);
//			statement.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

}
