package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import app.bean.RankOfTourInfo;
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
		List<RankOfTourInfo> arr = tourService.getAllTourByDateAndCity(idCity, ConvertDateSql.convertStringtoDateSQL(date_tour));
		for (RankOfTourInfo r : arr) {
			System.out.println(r.getDateStart());
		}
		return view;
	}
}
