package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import app.service.UserService;

@Controller
public class StudentController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public String index(Model model) {

		
		return "home";
	}

}
