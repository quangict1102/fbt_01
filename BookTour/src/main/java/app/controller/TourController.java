package app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.bean.TourInfo;
import app.helper.ConvertDateSql;
import app.service.CityService;
import app.service.TourService;

@Controller
@RequestMapping(value = { "/", "home" })
public class TourController {
	private static final Logger logger = Logger.getLogger(TourController.class);

	@Autowired
	TourService tourService;
	@Autowired
	CityService cityService;

	@GetMapping
	public ModelAndView index(Model model) {
		logger.info("home page");
		ModelAndView view = new ModelAndView("home");
		view.addObject("cities", cityService.getAllCity());
		model.addAttribute("tourToday",
				tourService.getTourToday(ConvertDateSql.getDateNowSQL()));
		return view;
	}

	@RequestMapping(value = "/tours")
	public String showTour(Model model) {
		logger.info("Table Tour page");
		model.addAttribute("addTour", new TourInfo());
		model.addAttribute("tour", new TourInfo());
		model.addAttribute("tours", tourService.loadAllTour());
		return "showTour";
	}

}
