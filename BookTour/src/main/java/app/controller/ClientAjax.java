package app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import app.bean.BookTourInfo;
import app.bean.CartInfo;
import app.bean.CommentInfo;
import app.bean.PlaceInfo;
import app.bean.TourInfo;
import app.bean.UserInfo;
import app.helper.ConvertDateSql;
import app.model.Bill;
import app.model.Booktour;
import app.model.Comment;
import app.model.Tour;
import app.model.User;

@Controller
@RequestMapping(value = "/clientAjax")
@SessionAttributes({ "userSession", "fullName","ibBookTour" })
public class ClientAjax extends BaseController {

	@GetMapping(path = "getAllPlaceByCity", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<PlaceInfo> getAllPlaceByCity(@RequestParam int id) {
		List<PlaceInfo> arr = new ArrayList<>();
		arr = placeService.getAllPlaceByIdCity(id);
		return arr;
	}

	@GetMapping(value = "/user/login", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String doLogin(Model model, @RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession httpSession) {
		User user = userService.findByEmailAndPassword(email, password);
		if ( null == user || !user.getRole().equals("user")) {
			return "error";
		}
		model.addAttribute("fullName", user.getFullName());
		CartInfo cartInfo = new CartInfo();
		cartInfo.setCountCart(bookingtourService.countCart(user.getId()));
		httpSession.setAttribute("cart", cartInfo.getCountCart());
		httpSession.setAttribute("userSession", user);
		return user.getFullName();
	}

	@GetMapping(value = "user/logout")
	@ResponseBody
	public String doLogout(HttpSession httpSession) {
		if (httpSession.getAttribute("userSession") != null) {
			httpSession.invalidate();
		}
		return "";
	}

	// 0 là cmt
	// 1 là reply cmt
	@PostMapping(value = "addComment")
	@ResponseBody
	public String addComment(@RequestParam("idTour") int idTour, @RequestParam("idUser") int idUser,
			@RequestParam("message") String message, @RequestParam("date") String date,
			@RequestParam("status") int status, HttpSession httpSession) {
		if (httpSession.getAttribute("userSession") == null) {
			return "";
		}
		setAddComment(idTour, idUser, message, status, date, httpSession);
		return "success";
	}

	private void setAddComment(int idTour, int idUser, String message, int status, String date,
			HttpSession httpSession) {
		Comment cmt = new Comment();
		cmt.setContext(message);
		cmt.setTime(ConvertDateSql.convertStringtoDateSQL(date));
		User currentUser = new User();
		currentUser.setId(idUser);
		cmt.setUser(currentUser);

		Tour tour = new Tour();
		tour.setId(idTour);
		cmt.setTour(tour);
		cmt.setStatus(status);
		commentService.saveOrUpdate(cmt);
	}

	@GetMapping(value = "loadComment", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<CommentInfo> loadComment(@RequestParam("idTour") int idTour, Model model) {
		return commentService.getAllCommentByIdTour(idTour);
	}
	
}
