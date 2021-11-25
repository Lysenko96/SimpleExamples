package net.gweep.servl.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.gweep.servl.config.Provider;
import net.gweep.servl.dao.BookDao;
import net.gweep.servl.entity.Book;
import net.gweep.servl.entity.Genre;

public class JdbcBookDao implements BookDao {

	private Provider provider;
	private static final String ADD_BOOK = "INSERT INTO books (name, author, genre, pageCount) VALUES (?,?,?,?)";
	private static final String GET_BOOK = "SELECT * FROM books WHERE id=?";
	private static final String GET_ALL_BOOKS = "SELECT * FROM books";
	private static final String UPDATE_BOOK = "UPDATE books SET name=?, author=?, genre=?, pageCount=? WHERE id=?";
	private static final String DELETE_BOOK = "DELETE FROM books WHERE id=?";

	public JdbcBookDao(Provider provider) {
		this.provider = provider;
	}

	// get generated id from db that object in memory has same id ?

	@Override
	public void add(Book book) {
		try (Connection connection = provider.connect();
				PreparedStatement statement = connection.prepareStatement(ADD_BOOK, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, book.getName());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getGenre().name());
			statement.setInt(4, book.getPageCount());
			statement.executeUpdate();
			ResultSet resultSet = statement.getGeneratedKeys();
			if (resultSet.next()) {
				int key = resultSet.getInt(1);
				book.setId(key);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book getById(int id) {
		Book book = null;
		try (Connection connection = provider.connect();
				PreparedStatement statement = connection.prepareStatement(GET_BOOK)) {
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String author = resultSet.getString("author");
				Genre genre = Genre.valueOf(resultSet.getString("genre"));
				int pageCount = resultSet.getInt("pageCount");
				book = new Book(id, name, author, genre, pageCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public List<Book> getAll() {
		List<Book> books = new ArrayList<>();
		try (Connection connection = provider.connect();
				PreparedStatement statement = connection.prepareStatement(GET_ALL_BOOKS)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String author = resultSet.getString("author");
				Genre genre = Genre.valueOf(resultSet.getString("genre"));
				int pageCount = resultSet.getInt("pageCount");
				books.add(new Book(id, name, author, genre, pageCount));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public boolean update(Book book) {
		boolean isUpdated = false;
		try (Connection connection = provider.connect();
				PreparedStatement statement = connection.prepareStatement(UPDATE_BOOK)) {
			statement.setString(1, book.getName());
			statement.setString(2, book.getAuthor());
			statement.setString(3, book.getGenre().name());
			statement.setInt(4, book.getPageCount());
			statement.setInt(5, book.getId());
			isUpdated = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUpdated;
	}

	@Override
	public boolean deleteById(int id) {
		boolean isDeleted = false;
		try (Connection connection = provider.connect();
				PreparedStatement statement = connection.prepareStatement(DELETE_BOOK)) {
			statement.setInt(1, id);
			isDeleted = statement.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isDeleted;
	}
}