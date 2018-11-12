package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "detailtour")
public class DetailTourController {

	@GetMapping
	public ModelAndView detailTour() {
		ModelAndView view = new ModelAndView("detailTour");
		return view;
	}
}
