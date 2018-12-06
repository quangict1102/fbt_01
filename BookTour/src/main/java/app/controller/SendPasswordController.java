package app.controller;

import org.apache.log4j.Logger;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import app.bean.UserInfo;

@Controller
@RequestMapping(value = "sendPassword")
public class SendPasswordController extends BaseController {
	private static final Logger logger = Logger.getLogger(SendPasswordController.class);

	@GetMapping
	public String show() {
		return "sendPassword";
	}

	@PostMapping(path = "/send")
	public String sendPassword(@RequestParam("email") String email, Model model) {
		logger.info("email: "+email);
		UserInfo userCurrent = userService.findByEmail(email);
		if (userCurrent == null) {
			model.addAttribute("sendLog", "sendErr");
		} else {
			SimpleMailMessage sendEmail = new SimpleMailMessage();
			sendEmail.setTo(email);
			sendEmail.setSubject("Password");
			sendEmail.setText(userCurrent.getPassword());
			mailSender.send(sendEmail);
			model.addAttribute("sendLog", "sendSuccess");
		}
		return "sendPassword";
	}
}
