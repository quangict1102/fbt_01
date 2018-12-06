package app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import app.bean.BookTourInfo;
import app.bean.TourInfo;
import app.helper.ConvertDateSql;
import app.model.Bill;
import app.model.Booktour;

@Controller
@RequestMapping(value = "/bills")
@SessionAttributes({ "userSession", "cart", "idtour" })
public class BillController extends BaseController {
	private static final Logger logger = Logger.getLogger(BillController.class);

	@GetMapping(value = "/{id}")
	public ModelAndView bill(@PathVariable("id") int id, HttpSession httpSession) {
		ModelAndView view = new ModelAndView("bills");
		List<BookTourInfo> btInfo = bookingtourService.getAllById(id);
		Integer id_tour = bookingtourService.getAllById(id).get(0).getTour().getId();
		TourInfo tourInfo = tourService.getAllById(id_tour);
		view.addObject("tourObject", tourInfo);
		view.addObject("detailTours", btInfo);
		view.addObject("id_bills", id);
		return view;
	}

	@PostMapping(path = "create")
	@ResponseBody
	public String addBill(@RequestParam("fullNameBill") String fullNameBill,
			@RequestParam("emailBill") String emailBill, @RequestParam("phoneBill") String phoneBill,
			@RequestParam("dateBill") String dateBill, @RequestParam("totailMoneyBill") String totailMoneyBill,
			@RequestParam("idTourBill") int idTourBill, HttpSession httpSession) {
		if (httpSession.getAttribute("userSession") == null) {
			return "";
		}
		setValueBill(fullNameBill, emailBill, phoneBill, dateBill, totailMoneyBill, idTourBill, httpSession);
		return "success";
	}

	private void setValueBill(String fullNameBill, String emailBill, String phoneBill, String dateBill,
			String totailMoneyBill, int idTourBill, HttpSession httpSession) {
		Bill billCurrent = new Bill();
		billCurrent.setFullName(fullNameBill);
		billCurrent.setEmail(emailBill);
		billCurrent.setPhoneNumber(totailMoneyBill);
		billCurrent.setTime(ConvertDateSql.convertStringtoDateSQL(dateBill));
		billCurrent.setTotailMoney(totailMoneyBill);
		Booktour booktour = new Booktour();
		booktour.setId(idTourBill);
		billCurrent.setBooktour(booktour);
		billService.saveOrUpdate(billCurrent);
	}
}
