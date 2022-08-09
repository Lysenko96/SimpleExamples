package com.spd.smartcooler.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spd.smartcooler.dao.RecipeDao;
import com.spd.smartcooler.entity.Product;
import com.spd.smartcooler.entity.Recipe;
import com.spd.smartcooler.provider.Provider;

import static com.spd.smartcooler.StartServlet.PATH_CONFIG;

public class JdbcRecipeDao implements RecipeDao {

	private Provider provider;
	private JdbcProductDao productDao;
	private static final String ADD_RECIPE = "insert into recipies (name, productid) values (?,?)";
	private static final String GET_RECIPE_BY_ID = "select * from recipies where id=?";
	private static final String GET_ALL_RECIPIES = "select * from recipies";
	private static final String UPDATE_RECIPE = "update recipies set name=?, productid=? where id=?";
	private static final String DELETE_RECIPE_BY_ID = "delete from recipies where id=?";
	private static final String FIND_PRODUCTS_BY_RECIPE_NAME = "select * from recipies where name=?";

	public JdbcRecipeDao(Provider provider, JdbcProductDao productDao) {
		this.provider = provider;
		this.productDao = productDao;
	}

	@Override
	public boolean add(Recipe recipe) {
		boolean isAdded = false;
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(ADD_RECIPE, Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, recipe.getName());
			st.setInt(2, recipe.getProduct().getId());
			isAdded = st.executeUpdate() > 0;
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				recipe.setId(key);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public Recipe getById(int id) {
		Recipe recipe = null;
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(GET_RECIPE_BY_ID)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int productId = rs.getInt("productid");
				Product product = productDao.getById(productId);
				recipe = new Recipe(id, name, product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recipe;
	}

	@Override
	public List<Recipe> getAll() {
		List<Recipe> recipies = new ArrayList<>();
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(GET_ALL_RECIPIES)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int productId = rs.getInt("productid");
				Product product = productDao.getById(productId);
				recipies.add(new Recipe(id, name, product));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return recipies;
	}

	@Override
	public boolean update(Recipe recipe) {
		boolean isUpdated = false;
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(UPDATE_RECIPE)) {
			st.setString(1, recipe.getName());
			st.setInt(2, recipe.getProduct().getId());
			st.setInt(3, recipe.getId());
			isUpdated = st.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public boolean deleteById(int id) {
		boolean isDeleted = false;
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(DELETE_RECIPE_BY_ID)) {
			st.setInt(1, id);
			isDeleted = st.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public List<Product> findProductsByRecipeName(String name) {
		return productDao.findProductsByString(name, FIND_PRODUCTS_BY_RECIPE_NAME, "productid");
	}
}