package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.helper.ConvertDateSql;
import app.service.RatingService;
import app.service.TourService;

@Controller
@RequestMapping(value = "product")
public class ProducController {
	
	@Autowired
	public RatingService ratingService;
	@Autowired
	public TourService tourService;
	
	@GetMapping(path="search")
	public ModelAndView product(@RequestParam(required =false) int idCity,@RequestParam String date_tour) {
		ModelAndView view = new ModelAndView("searchTourAdvance");
		view.addObject("ratings", ratingService.getAllRating());
		view.addObject("toures", tourService.getAllTourByDateAndCity(idCity, ConvertDateSql.convertStringtoDateSQL(date_tour)));
		return view;
	}
}
