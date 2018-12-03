package app.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.bean.CartInfo;
import app.bean.TourInfo;
import app.helper.PRIME_TOUR;
import app.model.Booktour;
import app.model.Tour;
import app.model.User;

@Controller
@RequestMapping(value = "/bookings")
@SessionAttributes({ "userSession", "cart" })
public class BookingController extends BaseController {
	private static final Logger logger = Logger.getLogger(BookingController.class);

	@GetMapping(path = "/{idTour}")
	public ModelAndView booking(@PathVariable("idTour") int idTour, HttpSession httpSession, Model model) {
		ModelAndView view = new ModelAndView("booking");
		TourInfo info = tourService.getAllById(idTour);
		model.addAttribute("tour", info);
		User currentUser = (User) httpSession.getAttribute("userSession");
		if (currentUser != null) {
			model.addAttribute("booktours", bookingtourService.getAllByIdUser(currentUser.getId()));
		}
		return view;
	}

	@PostMapping(value = "/{idTour}/add")
	public String addBookTour(@ModelAttribute("formBook") Booktour booktour, @PathVariable int idTour,
			HttpSession httpSession, Model model) {
		User currentUser = (User) httpSession.getAttribute("userSession");
		if (null == currentUser) {
			return "redirect:/bookings/{idTour}";
		}
		addBookTour(booktour, idTour, currentUser, httpSession);
		Long cart = (Long) httpSession.getAttribute("cart");
		CartInfo cartInfo = new CartInfo();
		if (cartInfo != null) {
			cartInfo.setCountCart(cart + 1);
			model.addAttribute("cart", cartInfo.getCountCart());
		}
		return "redirect:/bookings/{idTour}";
	}

	private void addBookTour(Booktour booktour, int idTour, User currentUser, HttpSession httpSession) {
		Booktour btInfo = new Booktour();
		btInfo.setChildren(booktour.getChildren());
		btInfo.setAdults(booktour.getAdults());
		Tour tour = new Tour();
		tour.setId(idTour);
		btInfo.setTour(tour);
		User user = new User();
		user.setId(currentUser.getId());
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
