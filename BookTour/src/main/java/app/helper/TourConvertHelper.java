package app.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import app.bean.TourInfo;
import app.model.Tour;

public class TourConvertHelper {
	static Function<Tour, TourInfo> tourToTourInfo = (Tour t) -> {
		TourInfo info = new TourInfo();
		info.setId(t.getId());
		info.setName(t.getName());
		info.setMaxPeople(t.getMaxPeople());
		info.setDescribe(t.getDescribe());
		info.setPrimeAdults(t.getPrimeAdults());
		info.setPrimeChilden(t.getPrimeChilden());
		info.setDurationTime(t.getDurationTime());
		info.setPlaceFromId(t.getPlaceFromId());
		info.setPlaceToId(t.getPlaceToId());
		info.setDateStart(t.getDateStart());
		return info;
	};

	public static List<TourInfo> convertTourToTourInfo(List<Tour> lTour) {
		List<TourInfo> arr = new ArrayList<>();
		for (Tour tour : lTour) {
			arr.add(tourToTourInfo.apply(tour));
		}
		return arr;
	}

	public static TourInfo convertSingleTourToTourInfo(Tour t) {
		return tourToTourInfo.apply(t);
	}

	static Function<TourInfo, Tour> tourInfoToTour = (TourInfo info) -> {
		Tour t = new Tour();
		t.setId(t.getId());
		t.setName(t.getName());
		t.setMaxPeople(t.getMaxPeople());
		t.setDescribe(t.getDescribe());
		t.setPrimeAdults(t.getPrimeAdults());
		t.setPrimeChilden(t.getPrimeChilden());
		t.setDurationTime(t.getDurationTime());
		t.setPlaceFromId(t.getPlaceFromId());
		t.setPlaceToId(t.getPlaceToId());
		t.setDateStart(t.getDateStart());
		return t;
	};

	public static List<Tour> convertTourInfoToTour(List<TourInfo> lTour) {
		List<Tour> arr = new ArrayList<>();
		for (TourInfo tour : lTour) {
			arr.add(tourInfoToTour.apply(tour));
		}
		return arr;
	}

	public static Tour convertSingleTourInfoToTour(TourInfo t) {
		return tourInfoToTour.apply(t);
	}
}
