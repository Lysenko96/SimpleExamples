package net.pack.carfactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.pack.carfactory.repo.CarRepo;
import net.pack.carfactory.repo.CarRepoImpl;
import net.pack.carfactory.service.CarService;
import net.pack.carfactory.service.CarServiceImpl;

@Configuration
public class Config {

	@Bean(name = "carService")
	public CarService getCarService(CarRepo carRepo) {
		return new CarServiceImpl(carRepo);
	}

	@Bean(name = "carRepo")
	public CarRepo getCarRepo() {
		return new CarRepoImpl();
	}
}