package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import app.service.UserService;

public class BaseController {
	@Autowired
	protected ReloadableResourceBundleMessageSource messageSource;
	
	@Autowired
	protected UserService userService;
}
