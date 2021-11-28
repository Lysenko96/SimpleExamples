package com.te.myservletmvn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.te.myservletmvn.entity.Book;
import com.te.myservletmvn.provider.Provider;

public class JdbcBookDao {

	private static final String GET_ALL_BOOKS = "select * from books";
	private static final String GET_BOOK_BY_PAGECOUNT = "select * from books where pageCount=?";

	public List<Book> findAll() {
		Connection connection = Provider.getInstance().getConnection();
		List<Book> result = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(GET_ALL_BOOKS);
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String author = rs.getString("author");
				String genre = rs.getString("genre");
				int pageCount = rs.getInt("pageCount");
				Book book = new Book(id, name, author, genre, pageCount);
				result.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public Optional<Book> findMoreByPageCount(int pageCount) {
		Connection connection = Provider.getInstance().getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(GET_BOOK_BY_PAGECOUNT);
			statement.setInt(1, pageCount);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String author = resultSet.getString(3);
				String genre = resultSet.getString(4);
				int count = resultSet.getInt(5);
				Book book = new Book(id, name, author, genre, count);
				System.out.println(book);
				return Optional.of(book);
			} else {
				return Optional.empty();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return Optional.empty();
		}
	}
}
