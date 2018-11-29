package app.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import app.bean.BookTourInfo;
import app.bean.TourInfo;
import app.bean.UserInfo;
import app.model.Booktour;
import app.model.Tour;
import app.model.User;

public class BookTourConvertHelper {
	static Function<Booktour, BookTourInfo> bookTourToBookTourInfo = (Booktour bt) -> {
		BookTourInfo btInfo = new BookTourInfo();
		btInfo.setId(bt.getId());
		btInfo.setPrimeTour(bt.getPrimeTour());
		btInfo.setStatus(bt.getStatus());
		btInfo.setAdults(bt.getAdults());
		btInfo.setChildren(bt.getChildren());
		btInfo.setNotel(bt.getNotel());
		TourInfo t = new TourInfo();
		t.setName(bt.getTour().getName());
		t.setId(bt.getTour().getId());
		btInfo.setTour(t);
		UserInfo u = new UserInfo();
		u.setId(bt.getUser().getId());
		btInfo.setUser(u);
		return btInfo;
	};

	public static List<BookTourInfo> convertBtToBtInfo(List<Booktour> lbt) {
		List<BookTourInfo> lbtInfo = new ArrayList<>();
		for (Booktour bt : lbt) {
			lbtInfo.add(bookTourToBookTourInfo.apply(bt));
		}
		return lbtInfo;
	}

	static Function<BookTourInfo, Booktour> bookTourInfoToBookTour = (BookTourInfo btInfo) -> {
		Booktour bt = new Booktour();
		bt.setId(btInfo.getId());
		bt.setPrimeTour(btInfo.getPrimeTour());
		bt.setStatus(btInfo.getStatus());
		bt.setAdults(btInfo.getAdults());
		bt.setChildren(btInfo.getChildren());
		bt.setNotel(btInfo.getNotel());
		Tour t = new Tour();
		t.setId(btInfo.getTour().getId());
		bt.setTour(t);
		User u = new User();
		u.setId(btInfo.getUser().getId());
		bt.setUser(u);
		return bt;
	};

	public static Booktour convertSingleBookTourInfoToBookTour(BookTourInfo btInfo) {
		return bookTourInfoToBookTour.apply(btInfo);
	}
}
