package app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import app.bean.BookTourInfo;
import app.bean.TourInfo;
import app.bean.UserInfo;
import app.model.Booktour;
import app.model.Tour;
import app.model.User;
import app.service.BookTourService;
import app.service.TourService;

@Controller
@RequestMapping(value = "/booking")
@SessionAttributes({ "userSession" })
public class BookingController {

	@Autowired
	TourService tourService;
	@Autowired
	BookTourService bookingtourService;

	@GetMapping(value = "/{id_tour}")
	public ModelAndView booking(@PathVariable int id_tour, HttpSession httpSession,
			Model model) {
		ModelAndView view = new ModelAndView("booking");
		TourInfo info = tourService.getAllById(id_tour);
		model.addAttribute("tour", info);
		return view;
	}

	@PostMapping(value = "/{id_tour}/add")
	public String addBookTour(@ModelAttribute("formBook") Booktour booktour, @PathVariable int id_tour,
			 HttpSession httpSession, Model model) {
		User u = (User) httpSession.getAttribute("userSession");
		if (null == u) {
			model.addAttribute("statusLogin", "Bạn cần đăng nhập");
			return "redirect:/booking/{id_tour}";
		}else{
		Booktour btInfo = new Booktour();
		btInfo.setChildren(booktour.getChildren());
		btInfo.setAdults(booktour.getAdults());
		Tour tour = new Tour();
		tour.setId(id_tour);
		btInfo.setTour(tour);
		User user = new User();
		user.setId(u.getId());
		btInfo.setUser(user);
		btInfo.setPrimeTour(booktour.getPrimeTour());
		btInfo.setStatus("0");
		btInfo.setNotel(booktour.getNotel());
		bookingtourService.saveOrUpdate(btInfo);
		model.addAttribute("statusLogin", "Book Tour thành công");
		return "redirect:/booking/{id_tour}";
		}
	}
}
