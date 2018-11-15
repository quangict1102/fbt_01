package app.service;

import java.util.Date;
import java.util.List;

import app.bean.TourInfo;

public interface TourService extends BaseService<Integer, TourInfo> {
	List<TourInfo> loadAllTour();

	List<TourInfo> findByPlace(String place);
	
	List<TourInfo> getTourToday(Date date);

	List<TourInfo> getAllTourByDateAndCity(int city, Date date);

}
