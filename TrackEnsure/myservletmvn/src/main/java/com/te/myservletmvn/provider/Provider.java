package com.te.myservletmvn.provider;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Provider {

	private volatile static Provider instance;

	private Connection connection;

	private Provider() {
		try {
			InitialContext context = new InitialContext();
			DataSource source = (DataSource) context.lookup("java:/comp/env/bookdb");
			if (source == null) {
				throw new IllegalArgumentException("DataSource not found!");
			} else {
				connection = source.getConnection();
			}
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Provider getInstance() {
		Provider provider = instance;
		if (provider == null) {
			synchronized (Provider.class) {
				provider = instance;
				if (provider == null) {
					instance = provider = new Provider();
				}
			}
		}
		return provider;
	}

	public Connection getConnection() {
		return connection;
	}

}
