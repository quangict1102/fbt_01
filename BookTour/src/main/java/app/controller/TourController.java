package app.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import app.service.TourService;

@Controller
@RequestMapping(value = "/")
public class TourController {
	private static final Logger logger = Logger.getLogger(TourController.class);

	@Autowired
	TourService tourService;
	@GetMapping
	public ModelAndView index() {
		logger.info("home page");
		ModelAndView model = new ModelAndView("home");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date dateUtil = null;
		try {
			dateUtil = dateFormat.parse(String.valueOf(LocalDate.now()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dateSql = new Date(dateUtil.getTime());
		model.addObject("tourToday", tourService.getTourToday(dateSql));
		System.out.println(dateFormat.format(dateSql));
		System.out.println(dateSql);
		return model;
	}

}
