package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.service.RatingService;

@Controller
@RequestMapping(value = "product")
public class ProducController {
	
	@Autowired
	public RatingService ratingService;
	
	@GetMapping(path="search")
	public ModelAndView product(@PathVariable int idCity,@PathVariable String date_tour) {
		ModelAndView view = new ModelAndView("searchTourAdvance");
		view.addObject("Ratings", ratingService.getAllRating());
		return view;
	}
}
