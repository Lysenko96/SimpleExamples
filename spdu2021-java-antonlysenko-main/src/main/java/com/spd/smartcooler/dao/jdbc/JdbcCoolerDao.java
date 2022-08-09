package com.spd.smartcooler.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.spd.smartcooler.dao.CoolerDao;
import com.spd.smartcooler.entity.Cooler;
import com.spd.smartcooler.entity.Product;
import com.spd.smartcooler.provider.Provider;

import static com.spd.smartcooler.StartServlet.PATH_CONFIG;

public class JdbcCoolerDao implements CoolerDao {

	private Provider provider;
	private JdbcProductDao productDao;
	private static final String ADD_COOLER = "insert into coolers (model, productid) values (?,?)";
	private static final String GET_COOLER_BY_ID = "select * from coolers where id=?";
	private static final String GET_ALL_COOLERS = "select * from coolers";
	private static final String UPDATE_COOLER = "update coolers set model=?, productid=? where id=?";
	private static final String DELETE_COOLER_BY_ID = "delete from coolers where id=?";
	private static final String FIND_PRODUCTS_BY_COOLER_MODEL = "select * from coolers where model=?";

	public JdbcCoolerDao(Provider provider, JdbcProductDao productDao) {
		this.provider = provider;
		this.productDao = productDao;
	}

	@Override
	public boolean add(Cooler cooler) {
		boolean isAdded = false;
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(ADD_COOLER, Statement.RETURN_GENERATED_KEYS)) {
			st.setString(1, cooler.getModel());
			st.setInt(2, cooler.getProduct().getId());
			isAdded = st.executeUpdate() > 0;
			ResultSet rs = st.getGeneratedKeys();
			if (rs.next()) {
				int key = rs.getInt(1);
				cooler.setId(key);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isAdded;
	}

	@Override
	public Cooler getById(int id) {
		Cooler cooler = null;
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(GET_COOLER_BY_ID)) {
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				String model = rs.getString("model");
				int productId = rs.getInt("productid");
				Product product = productDao.getById(productId);
				cooler = new Cooler(id, model, product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cooler;
	}

	@Override
	public List<Cooler> getAll() {
		List<Cooler> coolers = new ArrayList<>();
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(GET_ALL_COOLERS)) {
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String model = rs.getString("model");
				int productId = rs.getInt("productid");
				Product product = productDao.getById(productId);
				coolers.add(new Cooler(id, model, product));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coolers;
	}

	@Override
	public boolean update(Cooler cooler) {
		boolean isUpdated = false;
		try (Connection connection = provider.connect(PATH_CONFIG);
				PreparedStatement st = connection.prepareStatement(UPDATE_COOLER)) {
			st.setString(1, cooler.getModel());
			st.setInt(2, cooler.getProduct().getId());
			st.setInt(3, cooler.getId());
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
				PreparedStatement st = connection.prepareStatement(DELETE_COOLER_BY_ID)) {
			st.setInt(1, id);
			isDeleted = st.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

	public List<Product> findProductsByCoolerModel(String model) {
		return productDao.findProductsByString(model, FIND_PRODUCTS_BY_COOLER_MODEL, "productid");
	}

}