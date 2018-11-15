package app.controller;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.helper.ConvertDateSql;
import app.service.CityService;
import app.service.TourService;

@Controller
@RequestMapping(value = "/")
public class TourController {
	private static final Logger logger = Logger.getLogger(TourController.class);

	@Autowired
	TourService tourService;
	@Autowired
	CityService cityService;

	@GetMapping
	public ModelAndView index() {
		logger.info("home page");
		ModelAndView model = new ModelAndView("home");
		model.addObject("tourToday",
				tourService.getTourToday(ConvertDateSql.convertDateSql(String.valueOf(LocalDate.now()))));
		model.addObject("cities", cityService.getAllCity());
		return model;
	}

}
