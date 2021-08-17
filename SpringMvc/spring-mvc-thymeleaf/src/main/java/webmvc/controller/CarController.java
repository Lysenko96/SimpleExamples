package webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import webmvc.dao.CarDao;

@Controller
@RequestMapping("/cars")
public class CarController {

	private CarDao carDao;

	public CarController(CarDao carDao) {
		this.carDao = carDao;
	}
	
	@GetMapping("/findCars")
	public String findCars(Model model) {
		model.addAttribute("cars", carDao.getAll());
		System.out.println(model.getAttribute("cars"));
		return "findCars";
	}

	@GetMapping("/findCar/{id}")
	public String findCar(@PathVariable("id") int id, Model model) {
		model.addAttribute("car", carDao.getById(id));
		System.out.println(model.getAttribute("car"));
		return "findCar";
	}
}
