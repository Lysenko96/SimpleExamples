package com.te.webdb.provider;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SingleConnection {

	private DataSource source;
	private volatile static SingleConnection instance;
	private Connection connection;

	private SingleConnection() {
		try {
			InitialContext context = new InitialContext();
			source = (DataSource) context.lookup("java:/comp/env/jdbc/chinook");
			connection = source.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static SingleConnection getInstance() {
		SingleConnection local = instance;
		if (local == null) {
			synchronized (SingleConnection.class) {
				local = instance;
				if (local == null) {
					local = new SingleConnection();
					instance = local;
				}
			}
		}
		return local;
	}

}