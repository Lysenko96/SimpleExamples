package com.spd.smartcooler.dao.jdbc;

import static com.spd.smartcooler.StartServlet.PATH_CONFIG;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.spd.smartcooler.dao.ProductDao;
import com.spd.smartcooler.entity.Product;
import com.spd.smartcooler.entity.Type;
import com.spd.smartcooler.provider.ProviderTest;

import static com.spd.smartcooler.provider.ProviderTest.SCHEMA;

class JdbcProductDaoTest {

	private ProductDao productDao;

	@BeforeEach
	void setUp() {
		ProviderTest provider = new ProviderTest();
		productDao = new JdbcProductDao(provider);
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(SCHEMA)) {
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		productDao.add(new Product("apple", 5, Type.FRUIT, 10.5));
	}

	@Test
	void addTest() {
		boolean isAdded = productDao.add(new Product("apple", 5, Type.FRUIT, 10.5));
		assertEquals(true, isAdded);

	}

	@Test
	void getByIdTest() {
		Product expected = new Product(1, "apple", 5, Type.FRUIT, 10.5);
		Product actual = productDao.getById(1);
		assertEquals(expected, actual);
	}

	@Test
	void getAllTest() {
		List<Product> expected = List.of(new Product(1, "apple", 5, Type.FRUIT, 10.5));
		List<Product> actual = productDao.getAll();
		assertEquals(expected, actual);
	}

	@Test
	void updateTest() {
		boolean isUpdated = productDao.update(new Product(1, "banana", 10, Type.FRUIT, 36.5));
		assertEquals(true, isUpdated);
	}

	@Test
	void deleteByIdTest() {
		boolean isDeleted = productDao.deleteById(1);
		assertEquals(true, isDeleted);
	}
}