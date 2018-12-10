package app.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import app.bean.UserInfo;
import app.model.User;

@Controller
@RequestMapping(value = "/profileUser")
@SessionAttributes("userSession")
public class UserController extends BaseController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@GetMapping(path = "/{idUser}")
	public ModelAndView profile(@PathVariable("idUser") int idUser, HttpSession httpSession) {
		ModelAndView view = new ModelAndView("profileUser");
		User userCurrent = (User) httpSession.getAttribute("userSession");
		if (null != userCurrent) {
			view.addObject("user", userService.findByIdUser(idUser));
		}
		return view ;
	}

	@PostMapping(path = "/update")
	public String createUser(@ModelAttribute("updateUser") UserInfo userInfo, HttpSession httpSession) {
		User userCurrent = (User) httpSession.getAttribute("userSession");
		if (null != userCurrent) {
			UserInfo userCreate = new UserInfo();
			userCreate.setId(userCurrent.getId());
			userCreate.setFullName(userInfo.getFullName());
			userCreate.setAddress(userInfo.getAddress());
			userCreate.setEmail(userInfo.getEmail());
			userCreate.setGender(userInfo.getGender());
			userCreate.setPhoneNumber(userInfo.getPhoneNumber());
			userService.updateUser(userCreate);
		}
		return "redirect:/profileUser/"+userCurrent.getId()+"";
	}

}
