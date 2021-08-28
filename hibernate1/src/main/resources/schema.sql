DROP TABLE IF EXISTS Car_Driver;
DROP TABLE IF EXISTS Driver;
DROP TABLE IF EXISTS Car;

CREATE TABLE Car(
		id INT PRIMARY KEY AUTO_INCREMENT,
		model VARCHAR(50),
		speed INT
		);
		
CREATE TABLE Driver(
		id INT PRIMARY KEY AUTO_INCREMENT,
		name VARCHAR(50),
		surname VARCHAR(50),
		phone INT
		);
		
CREATE TABLE Car_Driver(
		car_id INT,
		FOREIGN KEY (car_id) REFERENCES Car (id),
		driver_id INT,
		FOREIGN KEY (driver_id) REFERENCES Driver (id),
		UNIQUE(car_id, driver_id)
		);