DROP TABLE IF EXISTS cars;
CREATE TABLE cars(
		id SERIAL PRIMARY KEY,
		model VARCHAR(35), 
		speed INT
		);
--INSERT INTO cars VALUES ('1','tesla','300');