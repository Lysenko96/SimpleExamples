DROP TABLE IF EXISTS users;
CREATE TABLE users(
		id SERIAL PRIMARY KEY,
		email VARCHAR(35) UNIQUE,
		password VARCHAR(60),
		name VARCHAR(50),
		surname VARCHAR(50),
		role VARCHAR(30)
		);