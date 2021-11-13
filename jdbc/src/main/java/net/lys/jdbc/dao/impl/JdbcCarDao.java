package net.lys.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.lys.jdbc.connection.Provider;
import net.lys.jdbc.dao.CarDao;
import net.lys.jdbc.entity.Car;

public class JdbcCarDao implements CarDao {

	private static final String ADD_CAR = "INSERT INTO Cars (name, speed, price) VALUES (?,?,?)";
	private static final String GET_CAR = "SELECT * FROM Cars WHERE id = ?";
	private static final String GET_ALL_CAR = "SELECT * FROM Cars";
	private static final String UPDATE_CAR = "UPDATE Cars SET name=?, speed=?, price=? WHERE id=?";
	private static final String DELETE_CAR = "DELETE FROM Cars WHERE id=?";

	Provider provider;

	public JdbcCarDao(Provider provider) {
		this.provider = provider;
	}

	@Override
	public void add(Car car) {
		try (Connection connection = provider.getConnection();
				PreparedStatement statement = connection.prepareStatement(ADD_CAR);) {
			statement.setString(1, car.getName());
			statement.setInt(2, car.getSpeed());
			statement.setInt(3, car.getPrice());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Car getById(int id) {
		try (Connection connection = provider.getConnection();
				PreparedStatement statement = connection.prepareStatement(GET_CAR);) {
			Car car = new Car();
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				car.setId(resultSet.getInt("id"));
				car.setName(resultSet.getString("name"));
				car.setSpeed(resultSet.getInt("speed"));
				car.setPrice(resultSet.getInt("price"));
			}
			return car;
		} catch (SQLException e) {

		}
		return new Car();
	}

	@Override
	public List<Car> getAll() {
		try (Connection connection = provider.getConnection(); Statement statement = connection.createStatement();) {
			ResultSet resultSet = statement.executeQuery(GET_ALL_CAR);
			List<Car> cars = new ArrayList<>();
			while (resultSet.next()) {
				Car car = new Car();
				car.setId(resultSet.getInt("id"));
				car.setName(resultSet.getString("name"));
				car.setSpeed(resultSet.getInt("speed"));
				car.setPrice(resultSet.getInt("price"));
				cars.add(car);
			}
			return cars;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	@Override
	public int update(Car car) {
		try (Connection connection = provider.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_CAR);) {
			statement.setString(1, car.getName());
			statement.setInt(2, car.getSpeed());
			statement.setInt(3, car.getPrice());
			statement.setInt(4, car.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return car.getId();
	}

	@Override
	public void deleteById(int id) {
		try (Connection connection = provider.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_CAR);) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}