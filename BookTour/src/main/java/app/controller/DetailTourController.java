package app.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import app.model.User;
import app.service.CommentService;

@Controller
@RequestMapping(value = "detailtours")

@SessionAttributes({ "userSession", "cart" })
public class DetailTourController extends BaseController{

	@Autowired
	CommentService cmtService;
	private static final Logger logger = Logger.getLogger(DetailTourController.class);

	@GetMapping(path = "/{id}")
	public ModelAndView show(@PathVariable("id") int id, HttpSession httpSession) {

		ModelAndView view = new ModelAndView("detailTours");
		view.addObject("idTour", id);
		view.addObject("tours", tourService.getAllById(id));
		if (httpSession.getAttribute("userSession") != null) {
			User user = (User) httpSession.getAttribute("userSession");
			view.addObject("idUser", user.getId());
			view.addObject("nameUser", user.getFullName());
		}

		return view;
	}
}
