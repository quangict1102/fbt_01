package app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.bean.TourInfo;
import app.helper.ConvertDateSql;
import app.model.Place;
import app.model.Tour;

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
		return "showTour";
	}

	@RequestMapping(value = "/addTour")
	public String addTour(@ModelAttribute("addTour") Tour tour, Model model,
			@RequestParam("dateStartConver") String strDate) {
		tourService.saveOrUpdate(strDate, tour);
		return "redirect:/tours";
	}

	@RequestMapping(value = "/tours/{id}")
	public String detailTour(Model model, @PathVariable("id") Integer id) {
		TourInfo tourInfo = tourService.findById(id);
		model.addAttribute("tourDetail", tourInfo);
		model.addAttribute("planceTo", placeService.findById(tourInfo.getPlaceToId()));
		model.addAttribute("planceFrom", placeService.findById(tourInfo.getPlaceFromId()));
		return "detailTour";
	}

	@RequestMapping(value = "/tours/{id}/edit")
	public String toEditTour(Model model, @PathVariable("id") Integer id) {
		
		model.addAttribute("tourEdit", tourService.findById(id));
		model.addAttribute("place", new Place());
		model.addAttribute("places", placeService.getAllPlace());
		return "editTour";
	}

	@RequestMapping(value = "/{id}" )
	public String update(@ModelAttribute("editTour") Tour tour, Model model,
			@RequestParam("dateStartConver") String strDate) {
		tourService.saveOrUpdate(strDate, tour);
		return "redirect:/tours";
	}

	@RequestMapping(value = "/tours/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		logger.info("delete Tour");
		 tourService.deleteTour(id);
		return "redirect:/tours";
	}

}
