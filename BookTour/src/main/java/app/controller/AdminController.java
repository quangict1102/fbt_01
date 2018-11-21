package app.controller;

import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.bean.UserInfo;
import app.helper.ROLES;
import app.model.User;

@Controller
public class AdminController extends BaseController {
	private static final Logger logger = Logger.getLogger(AdminController.class);

	@RequestMapping(value = "/admin")
	public ModelAndView home() {
		logger.info("home page");
		ModelAndView model = new ModelAndView("homeAdmin");
		model.addObject("user", new UserInfo());
		model.addObject("users", userService.loadUsers());
		return model;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {
		logger.info("delete User");
		userService.deleteUser(id);
		return "redirect:/admin";
	}

	@RequestMapping(value = "/users")
	public ModelAndView showUser() {
		logger.info("Table user page");
		ModelAndView model = new ModelAndView("showUser");
		model.addObject("user", new UserInfo());
		model.addObject("users", userService.loadUsers());
		return model;
	}

	
	@RequestMapping(value = "/login")
	public String toLoginAdmin(Model model) {
		model.addAttribute("userLogin", new UserInfo());
		return "adminLogin";
	}

	@RequestMapping(value = "/admin/login")
	public String doLoginAdmin(@ModelAttribute("UserLogin") UserInfo userInfo, Model model) {
		User user = userService.findByEmailAndPassword(userInfo.getEmail(), userInfo.getPassword());
		if (user == null || !user.getRole().equals(ROLES.ADMIN.toString())) {
			model.addAttribute("logNotice",
					messageSource.getMessage("login.invalid", null, LocaleContextHolder.getLocale()));
			return "forward:/adminLogin";
		}
		model.addAttribute("logNotice", messageSource.getMessage("login.valid", null, LocaleContextHolder.getLocale()));
		return "forward:/admin";

	}

}
