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

import app.bean.CartInfo;
import app.bean.TourInfo;
import app.helper.PRIME_TOUR;
import app.model.Booktour;
import app.model.Tour;
import app.model.User;
import app.service.BookTourService;
import app.service.TourService;

@Controller
@RequestMapping(value = "/booking")
@SessionAttributes({ "userSession", "cart" })
public class BookingController {

	@Autowired
	TourService tourService;
	@Autowired
	BookTourService bookingtourService;

	@GetMapping(value = "/{id_tour}")
	public ModelAndView booking(@PathVariable int id_tour, HttpSession httpSession, Model model) {
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
			return "redirect:/booking/{id_tour}";
		}
		addBookTour(booktour,id_tour,u);
		Long cart = (Long) httpSession.getAttribute("cart");
		CartInfo cartInfo = new CartInfo();
		if (cartInfo != null) {
			cartInfo.setCountCart(cart + 1);
			model.addAttribute("cart", cartInfo.getCountCart());
		}
		return "redirect:/booking/{id_tour}";
	}
	public void addBookTour(Booktour booktour,int id_tour,User u){
		Booktour btInfo = new Booktour();
		btInfo.setChildren(booktour.getChildren());
		btInfo.setAdults(booktour.getAdults());
		Tour tour = new Tour();
		tour.setId(id_tour);
		btInfo.setTour(tour);
		User user = new User();
		user.setId(u.getId());
		btInfo.setUser(user);
		String type_tour = booktour.getPrimeTour();
		switch (type_tour) {
		case "1":
			btInfo.setPrimeTour(PRIME_TOUR.selectPrime(PRIME_TOUR.TYPE1));
			break;
		case "2":
			btInfo.setPrimeTour(PRIME_TOUR.selectPrime(PRIME_TOUR.TYPE2));
			break;
		case "3":
			btInfo.setPrimeTour(PRIME_TOUR.selectPrime(PRIME_TOUR.TYPE3));
			break;			
		default:
			break;
		}
		btInfo.setStatus("0");
		btInfo.setNotel(booktour.getNotel());
		bookingtourService.saveOrUpdate(btInfo);
	}

}
