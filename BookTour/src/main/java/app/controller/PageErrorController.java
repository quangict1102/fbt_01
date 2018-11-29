package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/error")
public class PageErrorController {
	
	@GetMapping
	public ModelAndView error() {
		return new ModelAndView("pageError");
	}
}
