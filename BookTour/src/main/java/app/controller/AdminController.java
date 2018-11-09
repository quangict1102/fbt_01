package app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
import app.service.UserService;

@Controller
public class AdminController {
	private static final Logger logger = Logger.getLogger(AdminController.class);
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/admin")
	public ModelAndView home() {
		logger.info("home page");
		ModelAndView model = new ModelAndView("homeAdmin");
		model.addObject("user", new UserInfo());
		model.addObject("users", userService.loadUsers());
		return model;
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {
		logger.info("delete User");
		if (userService.deleteUser(id)) {
			System.out.println("s");
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "user is deleted!");
		} else {
			System.out.println("s2");
			redirectAttributes.addFlashAttribute("css", "error");
			redirectAttributes.addFlashAttribute("msg", "Delete user fails!!!!");
		}
		return "redirect:/admin";
	}

	@RequestMapping(value = "/tableUser")
	public ModelAndView showTableUser() {
		logger.info("Table user page");
		ModelAndView model = new ModelAndView("tableUser");
		model.addObject("user", new UserInfo());
		model.addObject("users", userService.loadUsers());
		return model;
	}

	@RequestMapping(value = "/register")
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/login")
	public String toLogin(Model model) {
		model.addAttribute("userLogin", new UserInfo());
		return "login";
	}

	@RequestMapping(value = "/admin/login")
	public String doLogin(@ModelAttribute("UserLogin") UserInfo userInfo, Model model) {
		User user = userService.findByEmailAndPassword(userInfo.getEmail(), userInfo.getPassword());
		if (user != null && user.getRole().equals("admin")) {
			model.addAttribute("messageLogin", "success");
			return "forward:/admin";
		}
		model.addAttribute("messageLogin", "err");
		return "forward:/login";
	}

	/*
	 * @RequestMapping(value = "/") public String index(Model model) { return
	 * "home"; }
	 */

}
