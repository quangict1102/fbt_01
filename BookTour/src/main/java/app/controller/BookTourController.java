package app.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping(path = {"/booktours", "/admin"})
@SessionAttributes({ "userSession", "cart", "idtour", "ibBookTour" })
public class BookTourController extends BaseController {

	private static final Logger logger = Logger.getLogger(BookTourController.class);

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
	public TourInfo edit(@RequestParam("idBt") int idBt, HttpSession httpSession) {
		httpSession.setAttribute("ibBookTour", idBt);
		return tourService.getAllById(bookingtourService.getAllById(idBt).get(0).getTour().getId());
	}

	@PostMapping(path = "/update")
	@ResponseBody
	public String update(@RequestParam("idTour") int idTour, @RequestParam("slnl") int slnl,
			@RequestParam("sltc") int sltc, @RequestParam("primeTour") String primeTour,
			@RequestParam("notel") String notel, HttpSession httpSession) {
		User currentUser = (User) httpSession.getAttribute("userSession");
		if (null == currentUser) {
			return "";
		}
		setValueBookTour(idTour, slnl, sltc, primeTour, notel, currentUser, httpSession);
		return "success";
	}


	@RequestMapping()
	public String IndexBookTours(Model model) {
		logger.info("Table BookTour page");
		model.addAttribute("bookTour", new Booktour());
		model.addAttribute("bookTours", bookingtourService.getAll());
		return "showBookTour";
	}

	@RequestMapping(value = "/booktours")
	public String index(Model model) {
		logger.info("Table BookTour page");
		model.addAttribute("bookTour", new Booktour());
		model.addAttribute("bookTours", bookingtourService.getAll());
		return "showBookTour";
	}

	@RequestMapping(value = "/booktours/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") Integer id) {
		logger.info("delete bookTour");
		bookingtourService.deleteBookTour(id);
		return "redirect:/bookTours";
	}

	private void setValueBookTour(int idTour, int slnl, int sltc, String primeTour, String notel, User currentUser,
			HttpSession httpSession) {
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
		bookingtourService.updateBt(bt);
	}

}
