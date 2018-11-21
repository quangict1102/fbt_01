package app.controller;

import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.model.User;

@Controller
public class UserController extends BaseController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/user/login", method = RequestMethod.GET)
	public String doLogin(Model model, @RequestParam("email") String email, @RequestParam("password") String password) {
		User user = userService.findByEmailAndPassword(email, password);
		if (user != null && user.getRole().equals("user")) {
			model.addAttribute("logNotice",
					messageSource.getMessage("login.valid", null, LocaleContextHolder.getLocale()));
			return "forward:/admin";
		}

		model.addAttribute("logNotice",
				messageSource.getMessage("login.invalid", null, LocaleContextHolder.getLocale()));
		return "forward:/";
	}
}
