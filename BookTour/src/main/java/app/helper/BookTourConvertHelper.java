package app.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import app.bean.BookTourInfo;
import app.bean.TourInfo;
import app.bean.UserInfo;
import app.model.Booktour;

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
		btInfo.setTour(t);
		UserInfo u = new UserInfo();
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
}
