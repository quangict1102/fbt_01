package app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.bean.BookTourInfo;
import app.bean.CartInfo;
import app.bean.TourInfo;
import app.bean.UserInfo;
import app.model.Booktour;
import app.model.User;

@Controller
@RequestMapping(path = "/booktours")
@SessionAttributes({ "userSession", "cart", "idtour", "ibBookTour" })
public class BookTourController extends BaseController {

	@GetMapping(path = "/{id}")
	public ModelAndView listbt(@PathVariable("id") int id, HttpSession httpSession) {
		ModelAndView view = new ModelAndView("listBookTour");
		User userCurrent = (User) httpSession.getAttribute("userSession");
		if (userCurrent != null) {
			view.addObject("booktours", bookingtourService.getAllByIdUser(userCurrent.getId()));
		}
		return view;
	}

	@PostMapping(path = "/{idTour}/del")
	public String deleteBt(@PathVariable("idTour") int id, final RedirectAttributes redirectAttributes, Model model,
			HttpSession httpSession) {
		if (bookingtourService.deleteBTbtId(id)) {
			Long cart = (Long) httpSession.getAttribute("cart");
			CartInfo cartInfo = new CartInfo();
			if (cartInfo != null) {
				cartInfo.setCountCart(cart - 1);
				model.addAttribute("cart", cartInfo.getCountCart());
			}
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Student is deleted!");
			return "redirect:/";
		}
		return "redirect:/error";

	}

	@GetMapping(path = "/edit", produces = "application/json;charset=utf-8")
	@ResponseBody
	public TourInfo editBookTour(@RequestParam("idBt") int idBt, HttpSession httpSession) {
		httpSession.setAttribute("ibBookTour", idBt);
		return tourService.getAllById(bookingtourService.getAllById(idBt).get(0).getTour().getId());
	}

	@PostMapping(path = "/update")
	@ResponseBody
	public String doEditBookTour(@RequestParam("idTour") int idTour, @RequestParam("slnl") int slnl,
			@RequestParam("sltc") int sltc, @RequestParam("primeTour") String primeTour,
			@RequestParam("notel") String notel, HttpSession httpSession) {
		User currentUser = (User) httpSession.getAttribute("userSession");
		if (null == currentUser) {
			return "";
		}
		Booktour bookTour = setValueBookTour(idTour, slnl, sltc, primeTour, notel, currentUser, httpSession);
		if (bookTour == null) {
			return "error";
		}
		return "success";
	}

	private Booktour setValueBookTour(int idTour, int slnl, int sltc, String primeTour, String notel,
			User currentUser, HttpSession httpSession) {
		BookTourInfo bt = new BookTourInfo();
		Integer idBookTour = (Integer) httpSession.getAttribute("ibBookTour");
		bt.setId(idBookTour);
		bt.setAdults(slnl);
		bt.setChildren(sltc);
		bt.setPrimeTour(primeTour);
		bt.setStatus("0");
		TourInfo tour = new TourInfo();
		tour.setId(idTour);
		bt.setTour(tour);
		UserInfo user = new UserInfo();
		user.setId(currentUser.getId());
		bt.setUser(user);
		bt.setNotel(notel);
		return bookingtourService.updateBt(bt);
	}
}
