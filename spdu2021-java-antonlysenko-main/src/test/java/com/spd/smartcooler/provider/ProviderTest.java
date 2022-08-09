package com.spd.smartcooler.provider;

import java.sql.Connection;

public class ProviderTest extends Provider {

 // get path for resource file
 // add tests and check data after test run (update, delete)

	private static final String PATH_CONFIG_TEST = "/home/anton/eclipse-workspace/smartcooler/src/test/resources/config.properties";
	public static final String SCHEMA = "drop table if exists coolers;" + "drop table if exists recipies;"
			+ "drop table if exists products;"

			+ "create table products(" + "id bigint auto_increment PRIMARY KEY," + "name varchar(55)," + "count int,"
			+ "type varchar(55)," + "price numeric(10,2)" + ");" + "create table coolers("
			+ "id bigint auto_increment PRIMARY KEY," + "model varchar(55)," + "productid int,"
			+ "foreign key (productid) references products (id)" + ");" + "create table recipies("
			+ "id bigint auto_increment PRIMARY KEY," + "name varchar(55)," + "productid int,"
			+ "foreign key (productid) references products (id)" + ");";

	@Override
	public Connection connect(String pathConfig) {
		return super.connect(PATH_CONFIG_TEST);
	}

}
