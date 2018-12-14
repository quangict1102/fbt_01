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
import org.springframework.web.multipart.MultipartFile;

import app.bean.CityInfo;
import app.model.City;
import app.model.Place;

@Controller
@RequestMapping(value ="/admin")
public class PlaceController extends BaseController {

	private static final Logger logger = Logger.getLogger(TourController.class);

	@RequestMapping(value = "/places")
	public String showTour(Model model) {

		logger.info("Table Place page");
		model.addAttribute("place", new Place());
		model.addAttribute("places", placeService.getAllPlace());
		model.addAttribute("cityInfo", new CityInfo());
		model.addAttribute("cityInfos", cityService.getAllCity());
		return "showPlace";
	}

	@RequestMapping(value = "/places/add",method=RequestMethod.POST)
	public String addTour(@ModelAttribute("addPlace") Place place, @RequestParam("idCity") int idCity,
			@RequestParam("files") MultipartFile[] files) {
		place.setCity(new City(idCity));
		placeService.saveOrUpdate(place,files);
		return "redirect:/admin/places";
	}

	@RequestMapping(value = "/places/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") int id, Model model) {
		logger.info("delete Tour ");
		placeService.deletePlace(id);
		return "redirect:/admin/places";
	}

}
