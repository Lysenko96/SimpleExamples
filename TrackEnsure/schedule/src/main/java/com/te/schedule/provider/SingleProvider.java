package com.te.schedule.provider;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class SingleProvider {

	private DataSource source;
	private volatile static SingleProvider instance;
	private Connection connection;

	private SingleProvider() {
		try {
			InitialContext context = new InitialContext();
			source = (DataSource) context.lookup("java:/comp/env/scheduledb");
			connection = source.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public static SingleProvider getInstance() {
		SingleProvider local = instance;
		if (local == null) {
			synchronized (SingleProvider.class) {
				local = instance;
				if (local == null) {
					instance = local = new SingleProvider();
				}
			}
		}
		return local;
	}
}