package app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.bean.TourInfo;
import app.helper.ConvertDateSql;
import app.model.Place;
import app.model.Tour;
import app.model.User;

@Controller
@RequestMapping(value = { "/", "home" })
public class TourController extends BaseController {
	private static final Logger logger = Logger.getLogger(TourController.class);

	@GetMapping
	public ModelAndView index(Model model) {
		logger.info("home page");
		ModelAndView view = new ModelAndView("home");
		view.addObject("cities", cityService.getAllCity());
		model.addAttribute("tourToday", tourService.getTourToday(ConvertDateSql.getDateNowSQL()));
		return view;
	}

	@RequestMapping(value = "/tours")
	public String showTour(Model model) {

		logger.info("Table Tour page");
		model.addAttribute("addTour", new TourInfo());
		model.addAttribute("tour", new TourInfo());
		model.addAttribute("tours", tourService.loadAllTour());
		model.addAttribute("place", new Place());
		model.addAttribute("places", placeService.getAllPlace());
		System.out.println(placeService.getAllPlace().get(1).getName());
		Tour tourInfo = new Tour("hanoi-s", 3, "dep", "10000", "10000", 6, 4, 3, null);
		tourService.saveOrUpdate(tourInfo);
		return "showTour";
	}

	@RequestMapping(value = "/addTour")
	public String addTour(@ModelAttribute("addTour") TourInfo tourInfo, Model model) {
		// tourService.saveOrUpdate(tourInfo);
		return "showTour";
	}

}
