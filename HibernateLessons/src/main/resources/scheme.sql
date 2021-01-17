DROP TABLE IF EXISTS driver_cars;
DROP TABLE IF EXISTS drivers;
DROP TABLE IF EXISTS keys;
DROP TABLE IF EXISTS cars;
CREATE TABLE cars(
 		car_id SERIAL PRIMARY KEY,
 		car_model VARCHAR(50), 
 		car_speed INT
		); 
CREATE TABLE keys(
		key_id SERIAL PRIMARY KEY,
		key_model VARCHAR(50)
);
CREATE TABLE drivers(
		driver_id SERIAL PRIMARY KEY,
		car_id INT,
		key_id INT,
 		driver_name VARCHAR(50),
 		driver_surname VARCHAR(50),
 		FOREIGN KEY (key_id) REFERENCES keys (key_id),
 		FOREIGN KEY (car_id) REFERENCES cars (car_id)
);
CREATE TABLE driver_cars(
		driver_id INT,
		FOREIGN KEY (driver_id) REFERENCES drivers (driver_id),
		car_id INT,
		FOREIGN KEY (car_id) REFERENCES cars (car_id),
		UNIQUE (driver_id, car_id)
);
		
--INSERT INTO cars (car_model, car_speed) VALUES ('Sauber Mercedes', 405);
--INSERT INTO drivers (car_id, driver_name, driver_surname) VALUES (1, 'Michael','Schumacher');