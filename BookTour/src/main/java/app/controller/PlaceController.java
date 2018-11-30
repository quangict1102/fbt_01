package app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import app.bean.CityInfo;
import app.bean.PlaceInfo;
import app.bean.TourInfo;
import app.model.City;
import app.model.Place;
import app.model.Tour;

@Controller
public class PlaceController extends BaseController{
	
	private static final Logger logger = Logger.getLogger(TourController.class);
	
	@RequestMapping(value = "/places")
	public String showTour(Model model) {
		
		logger.info("Table Place page");
		model.addAttribute("place", new Place());
		model.addAttribute("places", placeService.getAllPlace());
		model.addAttribute("cityInfo",new CityInfo());
		model.addAttribute("cityInfos", cityService.getAllCity());
		return "showPlace";
	}
	
	@RequestMapping(value = "/places/add")
	public String addTour(@ModelAttribute("addPlace") Place place ,@RequestParam("idCity")int idCity) {
		place.setCity(new City(idCity));
		placeService.saveOrUpdate(place);
		return "redirect:/places";
	}
	
	@RequestMapping(value = "/places/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") int id, Model model) {
		logger.info("delete Tour ");
		placeService.deletePlace(id);
		return "redirect:/tours";
	}
}
