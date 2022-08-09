package com.spd.smartcooler.dao.jdbc;

import static com.spd.smartcooler.StartServlet.PATH_CONFIG;
import static com.spd.smartcooler.provider.ProviderTest.SCHEMA;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.spd.smartcooler.dao.CoolerDao;
import com.spd.smartcooler.entity.Cooler;
import com.spd.smartcooler.entity.Product;
import com.spd.smartcooler.entity.Type;
import com.spd.smartcooler.provider.ProviderTest;

class JdbcCoolerDaoTest {

	private JdbcProductDao productDao;
	private CoolerDao coolerDao;

	@BeforeEach
	void setUp() {
		ProviderTest provider = new ProviderTest();
		productDao = new JdbcProductDao(provider);
		coolerDao = new JdbcCoolerDao(provider, productDao);
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(SCHEMA)) {
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		productDao.add(new Product("apple", 5, Type.FRUIT, 10.5));
		coolerDao.add(new Cooler("model", productDao.getById(1)));
	}

	@Test
	void addTest() {
		boolean isAdded = coolerDao.add(new Cooler("model", productDao.getById(1)));
		assertEquals(true, isAdded);

	}

	@Test
	void getByIdTest() {
		Cooler expected = new Cooler(1, "model", productDao.getById(1));
		Cooler actual = coolerDao.getById(1);
		assertEquals(expected, actual);
	}

	@Test
	void getAllTest() {
		List<Cooler> expected = List.of(new Cooler(1, "model", productDao.getById(1)));
		List<Cooler> actual = coolerDao.getAll();
		assertEquals(expected, actual);
	}

	@Test
	void updateTest() {
		productDao.update(new Product(1, "banana", 10, Type.FRUIT, 36.5));
		boolean isUpdated = coolerDao.update(new Cooler(1, "model", productDao.getById(1)));
		assertEquals(true, isUpdated);
	}

	@Test
	void deleteByIdTest() {
		boolean isDeleted = coolerDao.deleteById(1);
		assertEquals(true, isDeleted);
	}
}