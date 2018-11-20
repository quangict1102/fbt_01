package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "detailtour")
public class DetailTourController {

	@GetMapping(value="/{id}")
	public ModelAndView detailTour(@PathVariable int id,Model model) {
		ModelAndView view = new ModelAndView("detailTour");
		return view;
	}
}
