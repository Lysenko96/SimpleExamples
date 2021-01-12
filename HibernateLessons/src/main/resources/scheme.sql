DROP TABLE IF EXISTS cars;
CREATE TABLE cars(
 		car_id SERIAL PRIMARY KEY,
 		car_model VARCHAR(255), 
 		car_speed INT
		); 
		
INSERT INTO cars (car_model, car_speed) VALUES ('tesla', 220);