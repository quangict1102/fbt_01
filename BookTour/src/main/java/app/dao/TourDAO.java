package app.dao;

import java.util.Date;
import java.util.List;

import app.model.Tour;

public interface TourDAO extends BaseDAO<Integer, Tour> {
	List<Tour> loadAllTour();

	List<Tour> findByPlace(String place);

	List<Object[]> getTourToday(Date date);

}
