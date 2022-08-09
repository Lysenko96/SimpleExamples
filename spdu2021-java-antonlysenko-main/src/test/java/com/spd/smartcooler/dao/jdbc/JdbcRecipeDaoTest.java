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

import com.spd.smartcooler.dao.RecipeDao;
import com.spd.smartcooler.entity.Product;
import com.spd.smartcooler.entity.Recipe;
import com.spd.smartcooler.entity.Type;
import com.spd.smartcooler.provider.ProviderTest;

class JdbcRecipeDaoTest {

	private JdbcProductDao productDao;
	private RecipeDao recipeDao;

	@BeforeEach
	void setUp() {
		ProviderTest provider = new ProviderTest();
		productDao = new JdbcProductDao(provider);
		recipeDao = new JdbcRecipeDao(provider, productDao);
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(SCHEMA)) {
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		productDao.add(new Product("apple", 5, Type.FRUIT, 10.5));
		recipeDao.add(new Recipe("apple", productDao.getById(1)));
	}

	@Test
	void addTest() {
		boolean isAdded = recipeDao.add(new Recipe("apple", productDao.getById(1)));
		assertEquals(true, isAdded);

	}

	@Test
	void getByIdTest() {
		Recipe expected = new Recipe(1, "apple", productDao.getById(1));
		Recipe actual = recipeDao.getById(1);
		assertEquals(expected, actual);
	}

	@Test
	void getAllTest() {
		List<Recipe> expected = List.of(new Recipe(1, "apple", productDao.getById(1)));
		List<Recipe> actual = recipeDao.getAll();
		assertEquals(expected, actual);
	}

	@Test
	void updateTest() {
		productDao.update(new Product(1, "banana", 10, Type.FRUIT, 36.5));
		boolean isUpdated = recipeDao.update(new Recipe(1, "banana", productDao.getById(1)));
		assertEquals(true, isUpdated);
	}

	@Test
	void deleteByIdTest() {
		boolean isDeleted = recipeDao.deleteById(1);
		assertEquals(true, isDeleted);
	}
}