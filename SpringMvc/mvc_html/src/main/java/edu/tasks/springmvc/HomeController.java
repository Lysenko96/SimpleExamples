package edu.tasks.springmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ComponentScan("edu.tasks.springmvc")
public class HomeController {

	@RequestMapping(value = "/home")
	public String goHome() {
		return "static/html/home";
	}

}
