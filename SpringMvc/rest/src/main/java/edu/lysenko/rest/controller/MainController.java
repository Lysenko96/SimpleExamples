package edu.lysenko.rest.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

	Logger log = Logger.getLogger(MainController.class.getSimpleName());

	@GetMapping("/hello")
	public String getPage(@RequestParam(value = "a", required = false) Integer a,
			@RequestParam(value = "b", required = false) Integer b,
			@RequestParam(value = "act", required = false) String act, Model model) {

		log.info(act);

		model.addAttribute("model", a + act + b);

		log.info(model.getAttribute("a").toString());
		log.info(model.getAttribute("b").toString());
		log.info(model.getAttribute("act").toString());
		if (act.equals("add")) {
			int c = a + b;
			log.info(c + "");
		}
		return "/hello";
	}

	@GetMapping("/bye")
	public String getBye() {
		return "/bye";
	}
}
