package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import app.service.BillService;
import app.service.BookTourService;
import app.service.CityService;
import app.service.CommentService;
import app.service.PlaceService;
import app.service.TourService;
import app.service.UserService;

public class BaseController {
	@Autowired
	protected ReloadableResourceBundleMessageSource messageSource;

	@Autowired
	protected UserService userService;

	@Autowired
	protected PlaceService placeService;

	@Autowired

	protected TourService tourService;
	
	@Autowired
	protected CityService cityService;

	@Autowired
	protected CommentService commentService;
	
	@Autowired
	protected BookTourService bookingtourService;

	@Autowired
	BillService billService;
}
