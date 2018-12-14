package app.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.bean.UserInfo;
import app.helper.ExcelHelper;
import app.helper.ROLES;
import app.model.User;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {
	private static final Logger logger = Logger.getLogger(AdminController.class);

	@RequestMapping(value="/home")
	public String home(HttpSession httpSession,Model model) {
		logger.info("home page");
		if (httpSession.getAttribute("emailLoginSession") == null) {
			return "redirect:/admin/login";
		}
		model.addAttribute("bills",billService.loadAllbyTime());
		return "homeAdmin";
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteUser(@PathVariable("id") Integer id,
			final RedirectAttributes redirectAttributes) {
		logger.info("delete User");
		userService.deleteUser(id);
		return "redirect:/admin";
	}

	@RequestMapping(value = "/users")
	public ModelAndView index() {
		logger.info("Table user page");
		ModelAndView model = new ModelAndView("showUser");
		model.addObject("user", new UserInfo());
		model.addObject("users", userService.loadUsers());
		return model;
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String show(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("userDetail", userService.findById(id));
		return "detailUser";
	}

	@RequestMapping(value = "/login")
	public String toLoginAdmin(Model model, HttpSession httpSession) {
		if (httpSession.getAttribute("emailLoginSession") != null) {
			return "redirect:/admin/home";
		}
		return "adminLogin";
	}

	@RequestMapping(value = "/admin/login", method=RequestMethod.POST)
	public String doLoginAdmin(@ModelAttribute("UserLogin") UserInfo userInfo, Model model, HttpSession httpSession) {
		User user = userService.findByEmailAndPassword(userInfo.getEmail(), userInfo.getPassword());
		if (user == null || !user.getRole().equals(ROLES.ADMIN.toString())) {
			model.addAttribute("logNotice",
					messageSource.getMessage("login.invalid", null, LocaleContextHolder.getLocale()));

			return "forward:/admin/login";
		}
		httpSession.setAttribute("emailLoginSession", userInfo.getEmail());
		httpSession.setAttribute("idUserSession", user.getId());
		model.addAttribute("logNotice", messageSource.getMessage("login.valid", null, LocaleContextHolder.getLocale()));
		return "forward:/admin/home";
	}

	@RequestMapping(value = "/logout")
	public String logoutUser(Model model, HttpSession httppSession) {
		httppSession.setAttribute("emailLoginSession", null);
		return "redirect:/admin/login";
	}

	@RequestMapping(value = "/import", method = RequestMethod.POST)
	public String importExcel(@RequestParam("file") MultipartFile file) {
		userService.saveOrUpdate(ExcelHelper.readExcel(file));
		return "forward:/admin/users";

	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String showAcc(Model model, HttpSession httpSession) {
		model.addAttribute("AccDetail", userService.findById((Integer) httpSession.getAttribute("idUserSession")));
		return "detailAcc";
	}

	@RequestMapping(value = "/password", method = RequestMethod.POST)
	public String changePassword(HttpSession httpSession, @RequestParam("password") String password,
			@RequestParam("passwordRepeat") String passwordRepeat, @RequestParam("newPassword") String newPassword) {
		User user = userService.findByIdAndPassword((Integer) httpSession.getAttribute("idUserSession"), password);
		if (user == null) {
			return "detailAcc";
		}
		userService.saveOrUpdate(user);
		return "detailAcc";

	}


}
