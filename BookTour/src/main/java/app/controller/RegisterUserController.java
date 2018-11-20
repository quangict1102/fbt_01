package app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.bean.UserInfo;
import app.helper.Md5Helper;
import app.helper.ROLES;
import app.helper.UserConverHelper;
import app.model.User;

@Controller
@RequestMapping(value = "register")
@SessionAttributes({ "userSession" })
public class RegisterUserController extends BaseController {

	@GetMapping
	public ModelAndView register() {
		return new ModelAndView("registerUser");
	}

	@PostMapping(path = "/add")
	public String addUser(@ModelAttribute("userAdd") UserInfo userInfo, HttpSession httpSession,
			final RedirectAttributes redirectAttributes) {
		User u = (User) httpSession.getAttribute("userSession");
		if (null == u) {
			User user = UserConverHelper.convertSingleUserInfoToUser(userInfo);
			user.setRole(ROLES.USER.toString());
			user.setPassword(Md5Helper.getCodeMd5(userInfo.getPassword()));
			User userAdd = userService.saveOrUpdate(user);
			if (userAdd != null) {
				redirectAttributes.addFlashAttribute("css", "success");
				redirectAttributes.addFlashAttribute("msg", "Student is deleted!");
			} else {
				redirectAttributes.addFlashAttribute("css", "error");
				redirectAttributes.addFlashAttribute("msg", "Delete student fails!!!!");
			}
			
		}
		return "redirect:/register";
	}
}
