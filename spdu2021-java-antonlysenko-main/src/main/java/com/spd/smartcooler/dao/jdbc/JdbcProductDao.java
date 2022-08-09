package com.spd.smartcooler.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spd.smartcooler.dao.ProductDao;
import com.spd.smartcooler.entity.Product;
import com.spd.smartcooler.entity.Type;
import com.spd.smartcooler.provider.Provider;

import static com.spd.smartcooler.StartServlet.PATH_CONFIG;

public class JdbcProductDao implements ProductDao {

	private Provider provider;
	private static final String ADD_PRODUCT = "insert into products (name, count, type, price) values (?,?,?,?)";
	private static final String GET_PRODUCT_BY_ID = "select * from products where id=?";
	private static final String GET_ALL_PRODUCTS = "select * from products";
	private static final String UPDATE_PRODUCT = "update products set name=?, count=?, type=?, price=? where id=?";
	private static final String DELETE_PRODUCT_BY_ID = "delete from products where id=?";
	private static final String FIND_PRODUCT_BY_NAME = "select * from products where name=?";

	public JdbcProductDao(Provider provider) {
		this.provider = provider;
	}

	@Override
	public boolean add(Product product) {
		boolean isAdded = false;
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(ADD_PRODUCT, Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, product.getName());
			st.setInt(2, product.getCount());
			st.setString(3, product.getType().name());
			st.setDouble(4, product.getPrice());
			isAdded = st.executeUpdate() > 0;
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				product.setId(key);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public Product getById(int id) {
		Product product = null;
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(GET_PRODUCT_BY_ID)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String name = rs.getString("name");
				int count = rs.getInt("count");
				Type type = Type.valueOf(rs.getString("type"));
				double price = rs.getDouble("price");
				product = new Product(id, name, count, type, price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> getAll() {
		List<Product> products = new ArrayList<>();
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(GET_ALL_PRODUCTS)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int count = rs.getInt("count");
				Type type = Type.valueOf(rs.getString("type"));
				double price = rs.getDouble("price");
				products.add(new Product(id, name, count, type, price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public boolean update(Product product) {
		boolean isUpdated = false;
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(UPDATE_PRODUCT)) {
			st.setString(1, product.getName());
			st.setInt(2, product.getCount());
			st.setString(3, product.getType().name());
			st.setDouble(4, product.getPrice());
			st.setInt(5, product.getId());
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
				PreparedStatement st = connection.prepareStatement(DELETE_PRODUCT_BY_ID)) {
			st.setInt(1, id);
			isDeleted = st.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public List<Product> findProductsByString(String str, String sql, String column) {
		List<Product> products = new ArrayList<>();
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(sql)) {
			st.setString(1, str);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int idProduct = rs.getInt(column);
				Product product = getById(idProduct);
				products.add(new Product(idProduct, product.getName(), product.getCount(), product.getType(),
						product.getPrice()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public Product findProductByName(String name) {
		return findProductsByString(name, FIND_PRODUCT_BY_NAME, "id").get(0);
	}
}