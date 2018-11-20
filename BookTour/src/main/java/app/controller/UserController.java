package app.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import app.helper.ROLES;
import app.model.User;


@Controller
public class UserController extends BaseController {
	private static final Logger logger = Logger.getLogger(UserController.class);

}
