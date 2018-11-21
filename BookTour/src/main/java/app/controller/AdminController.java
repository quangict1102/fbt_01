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
		/*//User user= new User(id, fullName, gender, address, email, phoneNumber, password, role)
		//User entity= new User( 10,"hoang van quang", 0, "Nam Dinh", "quangict@gmail.com", "1432423", "12345678", "admin");
		userService.saveOrUpdate(entity);*/
		return model;
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {
		logger.info("delete User");
		if (userService.deleteUser(id)) {
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "user is deleted!");
		} else {
			redirectAttributes.addFlashAttribute("css", "error");
			redirectAttributes.addFlashAttribute("msg", "Delete user fails!!!!");
		}
		return "redirect:/admin";
	}

	@RequestMapping(value = "/users")
	public ModelAndView showUser() {
		logger.info("Table user page");
		ModelAndView model = new ModelAndView("showUser");
	//	model.addObject("user", new UserInfo());
		model.addObject("users", userService.loadUsers());
		return model;
	}

	@RequestMapping(value = "/adminRegister")
	public String register() {
		return "adminRegister";
	}

	@RequestMapping(value = "/adminLogin")
	public String toLoginAdmin(Model model) {
		model.addAttribute("userLogin", new UserInfo());
		return "adminLogin";
	}

	@RequestMapping(value = "/admin/login")
	public String doLoginAdmin(@ModelAttribute("UserLogin") UserInfo userInfo, Model model) {
		User user = userService.findByEmailAndPassword(userInfo.getEmail(), userInfo.getPassword());
		if (user != null && user.getRole().equals("user")) {
			model.addAttribute("logNotice",
					messageSource.getMessage("login.valid", null, LocaleContextHolder.getLocale()));
			return "forward:/admin";
		}
		model.addAttribute("logNotice", messageSource.getMessage("login.invalid", null, LocaleContextHolder.getLocale()));
		return "forward:/adminLogin";
	}
	/*
	 * @RequestMapping(value = "/") public String index(Model model) { return
	 * "home"; }
	 */

}
