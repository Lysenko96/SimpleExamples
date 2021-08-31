DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS user;
CREATE TABLE User(
		id INT PRIMARY KEY AUTO_INCREMENT,
		email VARCHAR(35) UNIQUE,
		password VARCHAR(60),
		name VARCHAR(50),
		surname VARCHAR(50),
		role VARCHAR(30),
		register DATE,
		lastLogin TIME
		);