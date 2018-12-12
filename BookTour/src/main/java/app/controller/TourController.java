package app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import app.bean.CartInfo;
import app.bean.GoogleInfo;
import app.bean.TourInfo;
import app.helper.ConvertDateSql;
import app.helper.Md5Helper;
import app.model.Place;
import app.model.Tour;
import app.model.User;

@Controller
@RequestMapping(value = { "/", "home", "admin" })
@SessionAttributes({ "userSession", "fullName", "cart" })
public class TourController extends BaseController {
	private static final Logger logger = Logger.getLogger(TourController.class);

	@GetMapping
	public ModelAndView index(Model model, HttpSession httpSession) {

		logger.info("home page");
		ModelAndView view = new ModelAndView("home");
		view.addObject("cities", cityService.getAllCity());
		model.addAttribute("tourToday", tourService.getTourToday(ConvertDateSql.getDateNowSQL()));
		User userCurrent = (User) httpSession.getAttribute("userSession");
		model.addAttribute("user", userCurrent);
		return view;
	}

	@GetMapping("/login-google")
	public String loginGoogle(HttpServletRequest request, HttpSession httpSession, Model model)
			throws ClientProtocolException, IOException {
		String code = request.getParameter("code");

		if (code == null || code.isEmpty()) {
			model.addAttribute("messageLogin", "err");
			return "redirect:/";
		}
		model.addAttribute("messageLogin", "success");
		String accessToken = googleUtils.getToken(code);
		GoogleInfo googleInfo = googleUtils.getUserInfo(accessToken);
		checkEmailAndPasswordByGoogle(googleInfo, model, httpSession);
		return "redirect:/";
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

	@RequestMapping(value = "/tours/add")
	public String addTour(@ModelAttribute("addTour") Tour tour, Model model,
			@RequestParam("dateStartConver") String strDate) {
		tourService.saveOrUpdate(strDate, tour);
		return "redirect:/tours";
	}

	@RequestMapping(value = "/tours/{id}", method = RequestMethod.GET)
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

	@RequestMapping(value = "/{id}")
	public String update(@ModelAttribute("editTour") Tour tour, Model model,
			@RequestParam("dateStartConver") String strDate) {
		System.out.println(tour.getId());
		tourService.saveOrUpdate(strDate, tour);
		return "redirect:/tours/{id}";
	}

	@RequestMapping(value = "/tours/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") int id, Model model) {
		logger.info("delete Tour ");
		tourService.deleteTour(id);
		return "redirect:/tours";
	}

	private void checkEmailAndPasswordByGoogle(GoogleInfo googleInfo, Model model, HttpSession httpSession) {
		User userCurrent = userService.findByEmailAndPassword(googleInfo.getEmail(), googleInfo.getId());
		if (userCurrent == null) {
			User userAdd = userService.saveOrUpdate(setValueUser(googleInfo));
			if (userAdd == null) {
				model.addAttribute("messageLogin", "err");
			} else {
				httpSession.setAttribute("userSession", userAdd);
				CartInfo cartInfo = new CartInfo();
				cartInfo.setCountCart(bookingtourService.countCart(userAdd.getId()));
				httpSession.setAttribute("cart", cartInfo.getCountCart());
			}
		} else {
			httpSession.setAttribute("userSession", userCurrent);
			CartInfo cartInfo = new CartInfo();
			cartInfo.setCountCart(bookingtourService.countCart(userCurrent.getId()));
			httpSession.setAttribute("cart", cartInfo.getCountCart());
		}
	}

	private User setValueUser(GoogleInfo googleInfo) {
		User user = new User();
		user.setEmail(googleInfo.getEmail());
		user.setPassword(Md5Helper.getCodeMd5(googleInfo.getId()));
		user.setFullName(googleInfo.getEmail());
		user.setRole("user");
		user.setAddress("");
		user.setPhoneNumber("");
		user.setGender(0);
		return user;
	}
	
	@GetMapping(value = "/tours/search", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<TourInfo> tourSearch(@RequestParam("searchTour") String search){
		return tourService.searchTourAndPlace(search);
		
	}
	@RequestMapping(value = "/tours/searchName")
	public String searchTourByName(Model model, @RequestParam("searchTour") String name) {
		logger.info("search Tour by name page");
		model.addAttribute("addTour", new TourInfo());
		model.addAttribute("tour", new TourInfo());
		model.addAttribute("tours", tourService.searchTourAndPlace(name));
		model.addAttribute("place", new Place());
		model.addAttribute("places", placeService.getAllPlace());
		return "showTour";
	}

}
