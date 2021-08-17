package webmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import webmvc.model.Car;

@Controller
public class CarController {

	@GetMapping("/showCar")
	public String showCar(Model model) {
		model.addAttribute("showCar", new Car("tesla", 235));
		System.out.println(model.getAttribute("showCar"));
		return "showCar";
	}
}
